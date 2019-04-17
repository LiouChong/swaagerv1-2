package com.bysj.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.bysj.common.exception.BussinessException;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.NumberChineseEx;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.PlaterDao;
import com.bysj.dao.PostDao;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.ManagePostQuery;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.request.AskhelpRequest;
import com.bysj.entity.vo.request.PostDel;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.PlateNameForIndex;
import com.bysj.entity.vo.response.PostBanResponse;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.entity.vo.response.PostResponse;
import com.bysj.service.IAskhelpService;
import com.bysj.service.IPostService;
import com.bysj.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 讨论帖子表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class PostServiceImpl extends BaseServiceImpl<Post> implements IPostService {
    private static final String fileURL = "D:\\user_file\\";
    @Resource
    private PlaterDao platerDao;
    @Resource
    private PostDao postDao;
    @Resource
    private BaseConverter<PostRequest, Post> requestConverter;
    @Resource
    private BaseConverter<Post, PostRequest> postRequestConverter;
    @Resource
    private BaseConverter<Post, PostResponse> responseConverter;
    @Resource
    private NumberChineseEx numberChineseEx;

    @Autowired
    private UserHandle userHandle;
    @Autowired
    private IAskhelpService askhelpService;
    @Autowired
    private IResourceService resourceService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer savePost(PostRequest request) throws Exception {
        Post post = requestConverter.convert(request, Post.class);

        Integer userId = userHandle.getUserId();
        Date nowDate = new Date();

        // 给帖子创建人、修改人、创建时间、修改时间赋值。
        post.setPosterId(userId);
        post.setCreateUser(userId);
        post.setModifyUser(userId);
        post.setGmtCreate(nowDate);
        post.setGmtModify(nowDate);

        // 如果帖子类型为资源贴。
        if (new Integer(2).equals(request.getArticleType())) {
            saveResource(request, post, userId, nowDate);
            postDao.insert(post);
        } else {
            // 插入帖子后，会自动将递增后的id返还给post对象。
            postDao.insert(post);
            saveAskHelp(request,post,userId,nowDate);
        }

        return 1;
    }

    private void saveResource(PostRequest request, Post post, Integer userId, Date nowDate) throws Exception {
        MultipartFile multipartFile = request.getMultipartFile();
        if (multipartFile.getSize() > 3 * 1024) {
            throw new BussinessException("文件上传过大");
        }
        File fileDir = new File(fileURL);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        // 加上用户id和时间戳防止文件重名
        String savePath = fileURL + userHandle.getUserId() + multipartFile.getOriginalFilename() + System.currentTimeMillis();

        com.bysj.entity.Resource resource = new com.bysj.entity.Resource();
        resource.setFileName(multipartFile.getOriginalFilename());
        resource.setFileSize(multipartFile.getSize());
        resource.setFileUrl(savePath);

        // 设置通用信息
        resource.setGmtCreate(nowDate);
        resource.setGmtModify(nowDate);
        resource.setUserCreate(userId);
        resource.setUserModify(userId);

        resourceService.save(resource);
        post.setResourceId(resource.getId());

        multipartFile.transferTo(new File(savePath));
    }

    private void saveAskHelp(PostRequest request, Post post,Integer userId, Date nowDate) {
        // 请求帮助的人，此时拿出来为字符串形式，下面转换为Json后转化为集合。
        String askHelpStr= request.getAskHelp();
        if (askHelpStr != null) {
            JSONArray objects = JSONArray.parseArray(askHelpStr);
            List<AskhelpRequest> askhelpRequestList = objects.toJavaList(AskhelpRequest.class);
            askhelpRequestList.forEach(item -> {
                // 给每一个请求赋值
                item.setPostId(post.getId());
                item.setSendQuestionUserId(userId);
                item.setMessage(post.getTitle());
                item.setGmtCreate(nowDate);

                try {
                    // 执行插入操作
                    askhelpService.saveAskhelp(item);
                } catch (Exception e) {
                    throw new BussinessException("系统异常，请稍后再试！");
                }
            });
        }
    }

    @Override
    public Integer updatePost(PostRequest request) throws Exception {
        Post post = requestConverter.convert(request, Post.class);
        return postDao.update(post);
    }
    @Override
    public List<PostResponse> findPagePost(PostQueryForList query, String pageName) throws Exception {
        List<PostResponse> postList;
        // 根据条件查询到符合的帖子集合
        if ("index".equals(pageName)) {
            postList = postDao.findPostForIndex();
        } else {
            postList = postDao.findPostQuery(query);
        }

        //对帖子集合进行数字中文转换
        postList.forEach(item -> {
            exChangeNumber(item);
            item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
            item.setGmtModifyStr(DateUtils.getDataString(item.getGmtModify(), DateUtils.WHOLE_FORMAT));
        });


        return postList;
    }

    @Override
    public Integer findPagePostCount(PostQueryForList query) throws Exception {
        return postDao.findPostQueryCount(query);
    }

    @Override
    public List<PostResponse> findPageSimplePost(PostSimpleQueryList queryList) {
        // 简单查询获取到结果
        List<PostResponse> postResponses = postDao.findPageSimplePost(queryList);

        // 对帖子集合进行数字中文转换
        for (PostResponse postRespons : postResponses) {
            exChangeNumber(postRespons);
        }

        return postResponses;
    }

    @Override
    public Integer findSimpleQueryCount(PostSimpleQueryList queryList) {
        return postDao.findSimpleQueryCount(queryList);
    }

    @Override
    public PostDetailResponse getPostDetailById(Integer id) throws Exception {
        PostDetailResponse postDetailResponse = postDao.findPostDetail(id);
        if (postDetailResponse != null) {
            // 对数字进行转换
            postDetailResponse.setIfGoodStr(numberChineseEx.numExchangeChinese(postDetailResponse, "ifGood"));
            postDetailResponse.setArticleFromStr(numberChineseEx.numExchangeChinese(postDetailResponse, "articleFrom"));
            postDetailResponse.setArticleTypeStr(numberChineseEx.numExchangeChinese(postDetailResponse, "articleType"));



            // 转换创建日期
            String gmtCreateStr = DateUtils.getDataString(postDetailResponse.getGmtCreate(), DateUtils.WHOLE_FORMAT);
            postDetailResponse.setGmrCreateStr(gmtCreateStr);

            //转换修改日期
            String gmtModifyStr = DateUtils.getDataString(postDetailResponse.getGmtModify(), DateUtils.WHOLE_FORMAT);
            postDetailResponse.setGmrCreateStr(gmtModifyStr);
        }

        // 阅读量 + 1
        Post allById = postDao.getAllById(id);
        allById.setReadCount(allById.getReadCount() + 1);
        postDao.update(allById);

        return postDetailResponse;
    }

    @Override
    public List<PlateNameForIndex> findAllPlateNames() {
        return platerDao.findAllPlateName();
    }

    private void exChangeNumber(PostResponse postResponse) {
        postResponse.setIfGoodStr(numberChineseEx.numExchangeChinese(postResponse, "ifGood"));
        postResponse.setArticleFromStr(numberChineseEx.numExchangeChinese(postResponse, "articleFrom"));
        postResponse.setArticleTypeStr(numberChineseEx.numExchangeChinese(postResponse, "articleType"));
    }

    @Override
    public List<PostResponse> findAllPostTimeDesc(ObjectQuery objectQuery) {
        List<PostResponse> allPostTimeDesc = postDao.findAllPostTimeDesc(objectQuery);
        for (PostResponse postResponse : allPostTimeDesc) {
            exChangeNumber(postResponse);
        }
        return allPostTimeDesc;
    }

    @Override
    public Integer findAllPostCount() {
        return postDao.findAllPostCount();
    }

    @Override
    public PageResult<PostBanResponse> findManagePagePost(ManagePostQuery managePostQuery) {
        return new PageResult<>(managePostQuery.getPageSize(), this.findPostCount(managePostQuery),
                managePostQuery.getCurrentPage(), this.findListBanPost(managePostQuery));
    }

    private List<PostBanResponse> findListBanPost(ManagePostQuery managePostQuery) {
        return postDao.findPageManagePost(managePostQuery);
    }

    private Integer findPostCount(ManagePostQuery managePostQuery) {
        return postDao.findPagePostCount(managePostQuery);
    }

    @Override
    public String calcenGoodPost(Post post) throws Exception {
        if (post.getId() == null) {
            return "文章选择不能为空！请刷新页面后再试";
        }
        post.setIfGood(0);
        post.setModifyUser(userHandle.getUserId());
        post.setGmtModify(new Date());

        return postDao.update(post).toString();
    }

    @Override
    public Integer setGoodPost(Post post) {
        post.setIfGood(1);
        post.setGmtModify(new Date());
        post.setModifyUser(userHandle.getUserId());
        return postDao.setGoodPost(post);
    }

    @Override
    public Integer delById(PostDel postDel) {
        postDel.setGmtModify(new Date());
        postDel.setModifyUser(userHandle.getUserId());
        return postDao.delPost(postDel);
    }

    @Override
    public Post getAllById(Integer id) {
        return postDao.getAllById(id);
    }

    @Override
    public Post getByResourceId(Integer id) {
        return postDao.getByResourceId(id);
    }
}
