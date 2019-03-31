package com.bysj.controller;


import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.ApplyPlateQuery;
import com.bysj.entity.vo.request.ApplyPlateRequest;
import com.bysj.service.IApplyPlateService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @author lc
 * @since 2019-03-12
 */
@Api(value = "ApplyPlate", description = "版主申请表")
@RestController
@RequestMapping("/applyplate")
public class ApplyPlateController {

    @Resource
    public IApplyPlateService iApplyPlateService;

    /**
     * 保存
     * @param applyPlateRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public String saveSingle(@ApiParam(value = "applyPlate") @RequestBody ApplyPlateRequest applyPlateRequest)throws Exception{
        String info = iApplyPlateService.saveApplyPlate(applyPlateRequest);
        return info;
    }

    /**
     * 批量查询
     * @param applyPlateQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "applyPlate") ApplyPlateQuery applyPlateQuery)throws Exception{
        return ActionResponse.success(iApplyPlateService.findPageApplyPlate(applyPlateQuery));
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
    public ActionResponse queryById(@ApiParam(value = "applyPlate") @PathVariable("id") Integer id)throws Exception{
        return ActionResponse.success(iApplyPlateService.getById(id));
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
        return ActionResponse.success(iApplyPlateService.deleteById(id));
    }
}

