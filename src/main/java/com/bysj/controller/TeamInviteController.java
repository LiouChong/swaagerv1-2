package com.bysj.controller;

import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.TeamInviteQuery;
import com.bysj.entity.vo.request.TeamInviteRequest;
import com.bysj.entity.vo.request.TeamInviteUpdateRequest;
import com.bysj.service.ITeamInviteService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author lc
 * @since 2019-04-07
 */
@Api(value = "TeamInvite", description = "")
@RestController
@RequestMapping("/teaminvite")
public class TeamInviteController {

    @Resource
    public ITeamInviteService iTeamInviteService;

    /**
     * 保存
     *
     * @param teamInviteRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "teamInvite") @RequestBody TeamInviteRequest teamInviteRequest) throws Exception {
        iTeamInviteService.saveTeamInvite(teamInviteRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     *
     * @param teamInviteRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "teamInvite") @RequestBody TeamInviteUpdateRequest teamInviteRequest) throws Exception {
        iTeamInviteService.updateTeamInvite(teamInviteRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     *
     * @param teamInviteQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "teamInvite") TeamInviteQuery teamInviteQuery) throws Exception {
        return ActionResponse.success(iTeamInviteService.findPageTeamInvite(teamInviteQuery));
    }

    /**
     * 通过ID查询
     *
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID查询", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ActionResponse queryById(@ApiParam(value = "teamInvite") @PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(iTeamInviteService.getById(id));
    }

    /**
     * 通过ID删除
     *
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ActionResponse deleteById(@ApiParam(value = "id") @PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(iTeamInviteService.deleteById(id));
    }

    /**
     * 拒绝小组邀请
     *
     * @param teamInviteId
     * @return actionResponse
     */
    @ApiOperation(value = "拒绝小组邀请", notes = "传入讨论组id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/defuse", method = RequestMethod.POST)
    public ActionResponse defuse(Integer  teamInviteId) {
        iTeamInviteService.defuseInvite(teamInviteId);
        return ActionResponse.success();
    }
}

