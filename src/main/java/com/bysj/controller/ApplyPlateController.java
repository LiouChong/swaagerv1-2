package com.bysj.controller;


import com.bysj.common.exception.BussinessException;
import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.request.ApplyPlatePassRequest;
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
     * 通过申请
     * @param applyPlateRequest
     * @return actionResponse
     */
    @ApiOperation(value = "通过申请", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    public ActionResponse passApply(@RequestBody ApplyPlatePassRequest applyPlateRequest)throws Exception{
        iApplyPlateService.passApply(applyPlateRequest);
        return ActionResponse.success();
    }


    /**
     * 通过ID删除
     * @param applyPlaterId
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/platerDefuse", method = RequestMethod.POST)
    public ActionResponse deleteById(Integer applyPlaterId)throws Exception{
        if (iApplyPlateService.refuseApply(applyPlaterId) != 0) {
            return ActionResponse.success();
        } else {
            throw new BussinessException("服务器异常！请稍后再试！");
        }

    }
}

