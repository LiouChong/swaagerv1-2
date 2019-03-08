package com.bysj.controller;

import com.bysj.common.response.ActionResponse;
import com.bysj.common.utils.PageUtil;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.PostResponse;
import com.bysj.service.IPostService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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


    @Resource
    public IPostService iPostService;

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
     * 分页获取推荐的帖子
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
        List<PostResponse> postList = iPostService.findPagePost(postQuery);
        Integer totalRecords = iPostService.findCount(postQuery);

        // 获取总页数
        int totalPage = PageUtil.getTotalPage(totalRecords, postQuery.getPageSize());
        mav.addObject("pageSize", postQuery.getPageSize());
        mav.addObject("totalRecords", totalRecords);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", postQuery.getCurrentPage());
        mav.addObject("postList", postList);

        // 设置跳转的页面
        mav.setViewName("index-2");
        return mav;
    }




    /**
     * 查询帖子
     *  TODO 这里暂时只通过 标题和内容查询，后期可以拓展为详细查询。
     * @param postQuery
     * @return actionResponse
     */
    @ApiOperation(value = "分页获取帖子", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/simple", method = RequestMethod.GET)
//    @RequiresPermissions("post:test")
    public ModelAndView queryList(@ApiParam(value = "post") PostSimpleQueryList postQuery, ModelAndView mav)throws Exception{
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
    public ActionResponse queryById(@ApiParam(value = "post") @PathVariable("id") Integer id)throws Exception{
        return ActionResponse.success(iPostService.getPostDetailById(id));
    }

    /**
     * 通过ID删除
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ActionResponse deleteById(@ApiParam(value = "id") @PathVariable("id") Integer id)throws Exception{

        return ActionResponse.success(iPostService.deleteById(id));
    }
}

