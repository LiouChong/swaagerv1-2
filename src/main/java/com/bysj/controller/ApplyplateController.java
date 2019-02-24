package com.bysj.controller;

import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.ApplyplateQuery;
import com.bysj.entity.vo.request.ApplyplateRequest;
import com.bysj.service.IApplyplateService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 *
 * @author lc
 * @since 2019-01-10
 */
@Api(value = "Applyplate", description = "用户申请版主表")
@RestController
@RequestMapping("/v1/bbs/applyplate")
public class ApplyplateController {

    @Resource
    public IApplyplateService iApplyplateService;

    /**
     * 保存
     * @param applyplateRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "applyplate") @RequestBody ApplyplateRequest applyplateRequest)throws Exception{
        iApplyplateService.saveApplyplate(applyplateRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param applyplateRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "applyplate")ApplyplateRequest applyplateRequest)throws Exception{
        iApplyplateService.updateApplyplate(applyplateRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param applyplateQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "applyplate") ApplyplateQuery applyplateQuery)throws Exception{
        return ActionResponse.success(iApplyplateService.findPageApplyplate(applyplateQuery));
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
    public ActionResponse queryById(@ApiParam(value = "applyplate") @PathVariable("id") Integer id)throws Exception{
        return ActionResponse.success(iApplyplateService.getById(id));
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
        return ActionResponse.success(iApplyplateService.deleteById(id));
    }
}

