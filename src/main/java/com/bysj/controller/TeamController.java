package com.bysj.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.*;
import com.bysj.common.request.ActionResponse;
import javax.annotation.Resource;
import com.antiy.common.utils.LogUtils;
import com.bysj.common.request.QueryCondition;
import com.antiy.common.utils.ParamterExceptionUtils;

import com.cuit.bbs.service.ITeamService;
import com.cuit.bbs.entity.Team;
import com.cuit.bbs.entity.vo.request.TeamRequest;
import com.cuit.bbs.entity.vo.response.TeamResponse;
import com.cuit.bbs.entity.vo.query.TeamQuery;


/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Team", description = "讨论组表")
@RestController
@RequestMapping("/v1/bbs/team")
public class TeamController {


    @Resource
    public ITeamService iTeamService;

    /**
     * 保存
     * @param teamRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "team") @RequestBody TeamRequest teamRequest)throws Exception{
        iTeamService.saveTeam(teamRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param teamRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "team")TeamRequest teamRequest)throws Exception{
        iTeamService.updateTeam(teamRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param teamQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "team") TeamQuery teamQuery)throws Exception{
        return ActionResponse.success(iTeamService.findPageTeam(teamQuery));
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
    public ActionResponse queryById(@ApiParam(value = "team") @PathVariable("id") Integer id)throws Exception{

        return ActionResponse.success(iTeamService.getById(id));
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

        return ActionResponse.success(iTeamService.deleteById(id));
    }
}

