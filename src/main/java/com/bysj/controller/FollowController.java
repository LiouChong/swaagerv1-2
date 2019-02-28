package com.bysj.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.*;
import com.antiy.common.base.ActionResponse;
import javax.annotation.Resource;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.QueryCondition;
import com.antiy.common.utils.ParamterExceptionUtils;

import com.cuit.bbs.service.IFollowService;
import com.cuit.bbs.entity.Follow;
import com.cuit.bbs.entity.vo.request.FollowRequest;
import com.cuit.bbs.entity.vo.response.FollowResponse;
import com.cuit.bbs.entity.vo.query.FollowQuery;


/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Follow", description = "关注人表")
@RestController
@RequestMapping("/v1/bbs/follow")
public class FollowController {
    private static final Logger logger = LogUtils.get();

    @Resource
    public IFollowService iFollowService;

    /**
     * 保存
     * @param followRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "follow") @RequestBody FollowRequest followRequest)throws Exception{
        iFollowService.saveFollow(followRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param followRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "follow")FollowRequest followRequest)throws Exception{
        iFollowService.updateFollow(followRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param followQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "follow") FollowQuery followQuery)throws Exception{
        return ActionResponse.success(iFollowService.findPageFollow(followQuery));
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
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ActionResponse queryById(@ApiParam(value = "follow") @PathVariable("id") Integer id)throws Exception{
        ParamterExceptionUtils.isNull(id, "ID不能为空");
        return ActionResponse.success(iFollowService.getById(id));
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
        ParamterExceptionUtils.isNull(id, "ID不能为空");
        return ActionResponse.success(iFollowService.deleteById(id));
    }
}

