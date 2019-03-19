package com.bysj.controller;

import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.ActionResponse;
import com.bysj.common.utils.PageUtil;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.request.PostDel;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.PlateNameForIndex;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.entity.vo.response.PostResponse;
import com.bysj.entity.vo.response.RandUserForHelpResponse;
import com.bysj.service.IPostService;
import com.bysj.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public ActionResponse saveSingle(@ApiParam(value = "post") @RequestBody PostRequest postRequest)throws Exception{
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

        mav.addObject("postList", postList);
        mav.addObject("plates", plateNameForIndices);

        // 设置跳转的页面
        mav.setViewName("index-2");
        return mav;
    }

    /**
     * 分页获取推荐的帖子
     * @param postQuery
     * @return actionResponse
     */
    @ApiOperation(value = "分页获取帖子", notes = "传入查询条件")
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
    @ApiOperation(value = "分页获取帖子", notes = "传入查询条件")
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
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID查询", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView queryById(@ApiParam(value = "post") @PathVariable("id") Integer id, ModelAndView modelAndView)throws Exception{
        PostDetailResponse postDetailResponse = iPostService.getPostDetailById(id);
        modelAndView.addObject("postDetail", postDetailResponse);
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
    public String deleteById(@RequestBody PostDel postDel)throws Exception{
        return iPostService.delById(postDel).toString();
    }

    /**
     * 按时间排序查询所有帖子
     *
     * @return actionResponse
     */
    @ApiOperation(value = "分页获取帖子", notes = "传入查询条件")
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
    public String setPostGood(@RequestBody Post post)throws Exception{
        Integer result = iPostService.setGoodPost(post);
        if (result.equals(1)) {
            return result.toString();
        } else {
            return "服务器异常，请稍后再试！";
        }
    }


}

