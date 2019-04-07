package com.bysj.controller;


import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.TeamQuery;
import com.bysj.entity.vo.request.TeamRequest;
import com.bysj.entity.vo.response.PlateNameForIndex;
import com.bysj.entity.vo.response.TeamDetailResponse;
import com.bysj.service.IPlaterService;
import com.bysj.service.IPostService;
import com.bysj.service.ITeamService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Team", description = "讨论组表")
@RestController
@RequestMapping("/team")
public class TeamController {


    @Resource
    public ITeamService iTeamService;

    @Autowired
    private IPostService postService;

    @Autowired
    private IPlaterService platerService;
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
    public ModelAndView queryById(@ApiParam(value = "team") @PathVariable("id") Integer id,ModelAndView modelAndView )throws Exception{
        TeamDetailResponse detail = iTeamService.getDetail(id);
        modelAndView.addObject("detail",detail);
        modelAndView.setViewName("team_detail");
        return modelAndView;
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

    /**
     * 获得创建讨论组页面
     * @param modelAndView
     * @return actionResponse
     */
    @ApiOperation(value = "获得创建讨论组页面", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getCreateTeamPage(ModelAndView modelAndView)throws Exception{
// 发帖时的所有板块
        List<PlateNameForIndex> plateNameForIndex = postService.findAllPlateNames();
        modelAndView.addObject("plates", plateNameForIndex);
        modelAndView.setViewName("create_team");
        return modelAndView;
    }
}

