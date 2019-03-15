package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.NumberChineseEx;
import com.bysj.dao.PlaterDao;
import com.bysj.dao.PostDao;
import com.bysj.entity.Plater;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.*;
import com.bysj.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private PlaterDao platerDao;
    @Resource
    private PostDao postDao;
    @Resource
    private BaseConverter<PostRequest, Post> requestConverter;
    @Resource
    private BaseConverter<Post, PostResponse> responseConverter;
    @Resource
    private NumberChineseEx numberChineseEx;


    @Override
    public Integer savePost(PostRequest request) throws Exception {
        Post post = requestConverter.convert(request, Post.class);

        return postDao.insert(post);
    }

    @Override
    public Integer updatePost(PostRequest request) throws Exception {
        Post post = requestConverter.convert(request, Post.class);
        return postDao.update(post);
    }
    @Override
    public List<PostResponse> findPagePost(PostQueryForList query) throws Exception {
        // 根据条件查询到符合的帖子集合
        List<PostResponse> postList = postDao.findPostQuery(query);

        //对帖子集合进行数字中文转换
        postList.forEach(item -> {
            exChangeNumber(item);
            item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
            item.setGmtModifyStr(DateUtils.getDataString(item.getGmtModify(), DateUtils.WHOLE_FORMAT));
        });


        return postList;
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
    public PostDetailResponse getPostDetailById(Integer id) {
        PostDetailResponse postDetailResponse = postDao.findPostDetail(id);

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

        // 查询得到帖子的回复信息
        List<ReplyForPostDetail> replys = postDao.findReplyForPost(id);

        // 对回复信息的日期进行转换
        replys.forEach(item -> {
            item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(),DateUtils.WHOLE_FORMAT));
        });

        postDetailResponse.setReplys(replys);

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
    public PageResult<PostBanResponse> findPageBanPost(ObjectQuery objectQuery) {
        return new PageResult<>(objectQuery.getPageSize(), this.findBanPostCount(),
                objectQuery.getCurrentPage(), this.findListBanPost(objectQuery));
    }

    private List<PostBanResponse> findListBanPost(ObjectQuery objectQuery) {
        return postDao.findPageBanPost(objectQuery);
    }

    private Integer findBanPostCount() {
        return postDao.findPageBanPostCount();
    }
}
