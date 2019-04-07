package com.bysj.controller;

import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.ActionResponse;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.NumberChineseEx;
import com.bysj.common.utils.PageUtil;
import com.bysj.common.utils.UserHandle;
import com.bysj.entity.Post;
import com.bysj.entity.Resource;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.query.PrivateLetterQuery;
import com.bysj.entity.vo.query.ReplyQuery;
import com.bysj.entity.vo.request.PostDel;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.*;
import com.bysj.service.*;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Post", description = "讨论帖子表")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    public IPostService iPostService;

    @Autowired
    public IUserService userService;

    @Autowired
    private IReplyService replyService;

    @Autowired
    private IFavoritesArticleService favoritesArticleService;

    @Autowired
    private IPlaterService platerService;

    @Autowired
    private IPrivateLetterService privateLetterService;

    @Autowired
    private UserHandle userHandle;

    @Autowired
    private NumberChineseEx numberChineseEx;

    @Autowired
    private IResourceService resourceService;

    @Autowired
    private ITeamService teamService;

    /**
     * 保存
     * @param postRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    @RequiresAuthentication
    public ActionResponse saveSingle(@ApiParam(value = "post") PostRequest postRequest)throws Exception{
        iPostService.savePost(postRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param postRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "post")PostRequest postRequest)throws Exception{
        iPostService.updatePost(postRequest);
        return ActionResponse.success();
    }

    /**
     * 首页信息
     * @param postQuery
     * @return actionResponse
     */
    @ApiOperation(value = "分页获取帖子", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView queryGoodList(@ApiParam(value = "post") PostQueryForList postQuery, ModelAndView mav)throws Exception{
        //首页查看被推荐文章，因此在这里设置查询条件为被推荐文章
        postQuery.setIfGood(1);

        // 获取帖子列表与总记录数
        List<PostResponse> postList = iPostService.findPagePost(postQuery,"index");
        //获取板块名称
        List<PlateNameForIndex> plateNameForIndices = iPostService.findAllPlateNames();


        if (userHandle.getUserId() != null) {
            // 如果已经登陆则查询私信信息。
            PrivateLetterQuery privateLetterQuery = new PrivateLetterQuery();
            privateLetterQuery.setUserSendRev(userHandle.getUserId());
            privateLetterQuery.setIfRead(0);

            List<PrivateLetterResponse> privateLetters = privateLetterService.findListPrivateLetter(privateLetterQuery);

            privateLetters.forEach(item -> {
                item.setLetterType(numberChineseEx.numExchangeChinese(item, "letterType"));
                item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
            });
            mav.addObject("privateLetter", privateLetters);

            // 如果已经登录则查询讨论组信息
            List<TeamIndexResponse> teamIndexResponse = teamService.selectForIndex(userHandle.getUserId());
            mav.addObject("teams",teamIndexResponse);
        }


        mav.addObject("postList", postList);
        mav.addObject("plates", plateNameForIndices);
        // 设置跳转的页面
        mav.setViewName("index");
        return mav;
    }

    /**
     * 分页获取推荐的帖子
     * @param postQuery
     * @return actionResponse
     */
    @ApiOperation(value = "分页获取推荐帖子", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/good", method = RequestMethod.GET)
    public ModelAndView queryAllGoodPost(@ApiParam(value = "post") PostQueryForList postQuery, ModelAndView mav)throws Exception{
        //首页查看被推荐文章，因此在这里设置查询条件为被推荐文章
        postQuery.setIfGood(1);

        // 获取帖子列表与总记录数
        List<PostResponse> postList = iPostService.findPagePost(postQuery,"articleGood");
        Integer totalRecords = iPostService.findCount(postQuery);

        // 获取总页数
        int totalPage = PageUtil.getTotalPage(totalRecords, postQuery.getPageSize());

        //获取板块名称
        List<PlateNameForIndex> plateNameForIndices = iPostService.findAllPlateNames();

        mav.addObject("pageSize", postQuery.getPageSize());
        mav.addObject("totalRecords", totalRecords);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", postQuery.getCurrentPage());
        mav.addObject("postList", postList);
        mav.addObject("plates", plateNameForIndices);

        // 设置跳转的页面
        mav.setViewName("articles-good-list");
        return mav;
    }




    /**
     * 查询帖子
     *
     * @param postQuery
     * @return actionResponse
     */
    @ApiOperation(value = "简单查询帖子", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/simple", method = RequestMethod.GET)
    // @RequiresPermissions("post:test")
    public ModelAndView queryList(@ApiParam(value = "post") PostSimpleQueryList postQuery, ModelAndView mav)throws Exception{
        // TODO 这里暂时只通过 标题和内容查询，后期可以拓展为详细查询。
        // 获取帖子列表与总记录数
        List<PostResponse> postList = iPostService.findPageSimplePost(postQuery);
        Integer totalRecords = iPostService.findSimpleQueryCount(postQuery);
        Integer pageSize = postQuery.getPageSize();
        // 获取总页数
        Integer totalPage = PageUtil.getTotalPage(totalRecords, pageSize);
        mav.addObject("pageSize", postQuery.getPageSize());
        mav.addObject("totalRecords", totalRecords);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", postQuery.getCurrentPage());
        mav.addObject("postList", postList);

        // 设置跳转的页面
        mav.setViewName("search_result");
        return mav;
    }

    /**
     * 通过ID查询
     * @param replyQuery
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID查询", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @Transactional
    public ModelAndView queryById(@ApiParam(value = "post") ReplyQuery replyQuery, ModelAndView modelAndView)throws Exception{
        PostDetailResponse postDetailResponse = iPostService.getPostDetailById(replyQuery.getPostId());
        if (postDetailResponse.getArticleType().equals(2)) {
            Resource resource = resourceService.getById(postDetailResponse.getResourceId());
            if (resource == null) {
                modelAndView.addObject("resource",new Resource());
            } else {
                modelAndView.addObject("resource",resource);
            }

        } else {
            modelAndView.addObject("resource",new Resource());
        }
        // 分页查询回复
        PageResult<ReplyForPostDetail> pageReply = replyService.findPageReply(replyQuery);
        postDetailResponse.setReplys(pageReply.getItems());

        // 若又收藏信息，则表示已收藏
        if (favoritesArticleService.getIfCollectByUserId(postDetailResponse.getPosterId(), postDetailResponse.getId()) != null) {
            postDetailResponse.setCollectBoolean(true);
        } else {
            postDetailResponse.setCollectBoolean(false);
        }

        modelAndView.addObject("postDetail", postDetailResponse);
        modelAndView.addObject("currentPage", pageReply.getCurrentPage());
        modelAndView.addObject("totalRecord", pageReply.getTotalRecords());
        modelAndView.addObject("totalPage", pageReply.getTotalPages());
        modelAndView.setViewName("single");
        return modelAndView;
    }

    /**
     * 通过ID删除
     * @param postDel
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("post:delete")
    public String deleteById(@RequestBody PostDel postDel)throws Exception{
        return iPostService.delById(postDel).toString();
    }

    /**
     * 按时间排序查询所有帖子
     *
     * @return actionResponse
     */
    @ApiOperation(value = "按时间排序查询所有帖子", notes = "传入查询条件")
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ModelAndView queryPostList(ObjectQuery objectQuery, ModelAndView mav)throws Exception{
        // 获取帖子列表与总记录数
        List<PostResponse> postList = iPostService.findAllPostTimeDesc(objectQuery);
        Integer totalRecords = iPostService.findAllPostCount();
        Integer pageSize = objectQuery.getPageSize();
        // 获取总页数
        Integer totalPage = PageUtil.getTotalPage(totalRecords, pageSize);
        mav.addObject("pageSize", pageSize);
        mav.addObject("totalRecords", totalRecords);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", objectQuery.getCurrentPage());
        mav.addObject("postList", postList);

        // 设置跳转的页面
        mav.setViewName("articles-list");
        return mav;
    }
    /**
     * 获取发帖页面
     *
     * @return actionResponse
     */
    @ApiOperation(value = "获取发帖", notes = "传入查询条件")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @RequiresAuthentication
    public ModelAndView getPostAddPage(ModelAndView mav)throws Exception{
        // 发帖时的所有板块
        List<PlateNameForIndex> plateNameForIndex = iPostService.findAllPlateNames();
        // 发帖时的邀请人
        List<RandUserForHelpResponse> randUserForHelpResponses = userService.findRandUser();

        // 赋值
        mav.addObject("plates",plateNameForIndex);
        mav.addObject("helpUsersOne", randUserForHelpResponses.subList(0, 4));
        mav.addObject("helpUsersTwo", randUserForHelpResponses.subList(4, 8));
        mav.addObject("helpUsersThree", randUserForHelpResponses.subList(8, 12));

        // 设置跳转的页面
        mav.setViewName("publish_post");
        return mav;
    }

    /**
     * 取消推荐帖子
     *
     * @return actionResponse
     */
    @ApiOperation(value = "取消推荐的帖子", notes = "传入修改条件")
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @RequiresPermissions("post:un_good")
    public String cancelGoodPost(@RequestBody Post post)throws Exception{
        String result = iPostService.calcenGoodPost(post);
        return result;
    }

    /**
     * 推荐帖子
     *
     * @return actionResponse
     */
    @ApiOperation(value = "取消推荐的帖子", notes = "传入修改条件")
    @RequestMapping(value = "/setGood", method = RequestMethod.POST)
    @RequiresPermissions("post:good")
    public String setPostGood(@RequestBody Post post)throws Exception{
        Integer result = iPostService.setGoodPost(post);
        if (result.equals(1)) {
            return result.toString();
        } else {
            return "服务器异常，请稍后再试！";
        }
    }

    /**
     * 分板块展示帖子
     *
     * @return actionResponse
     */
    @ApiOperation(value = "分板块展示帖子", notes = "传入修改条件")
    @RequestMapping(value = "/plate/list", method = RequestMethod.GET)
    public ModelAndView getPostByPlate(PostQueryForList postQueryForList, ModelAndView modelAndView) throws Exception{
        List<PostResponse> platePost = iPostService.findPagePost(postQueryForList, "platePost");

        Integer totalRecords = iPostService.findCount(postQueryForList);

        // 获取总页数
        int totalPage = PageUtil.getTotalPage(totalRecords, postQueryForList.getPageSize());

        modelAndView.addObject("pageSize", postQueryForList.getPageSize());
        modelAndView.addObject("totalRecords", totalRecords);
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.addObject("currentPage", postQueryForList.getCurrentPage());
        modelAndView.addObject("postList", platePost);
        modelAndView.addObject("plateId", postQueryForList.getPlateId());
        modelAndView.addObject("plateOwnerName", platerService.getUserNameForPlate(postQueryForList.getPlateId()));
        // 设置跳转的页面
        modelAndView.setViewName("postsByPlate");
        return modelAndView;
    }

}

