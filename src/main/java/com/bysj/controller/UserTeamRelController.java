package com.bysj.controller;


import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.UserTeamRelQuery;
import com.bysj.entity.vo.request.UserTeamRelRequest;
import com.bysj.service.IUserTeamRelService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "UserTeamRel", description = "用户小组关联表")
@RestController
@RequestMapping("/userteamrel")
public class UserTeamRelController {


    @Resource
    public IUserTeamRelService iUserTeamRelService;

    /**
     * 保存
     * @param userTeamRelRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "userTeamRel") @RequestBody UserTeamRelRequest userTeamRelRequest)throws Exception{
        iUserTeamRelService.saveUserTeamRel(userTeamRelRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param userTeamRelRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "userTeamRel")UserTeamRelRequest userTeamRelRequest)throws Exception{
        iUserTeamRelService.updateUserTeamRel(userTeamRelRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param userTeamRelQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "userTeamRel") UserTeamRelQuery userTeamRelQuery)throws Exception{
        return ActionResponse.success(iUserTeamRelService.findPageUserTeamRel(userTeamRelQuery));
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
    public ActionResponse queryById(@ApiParam(value = "userTeamRel") @PathVariable("id") Integer id)throws Exception{

        return ActionResponse.success(iUserTeamRelService.getById(id));
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

        return ActionResponse.success(iUserTeamRelService.deleteById(id));
    }
}

