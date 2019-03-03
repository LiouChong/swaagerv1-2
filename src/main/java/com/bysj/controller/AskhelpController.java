package com.bysj.controller;

import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.AskhelpQuery;
import com.bysj.entity.vo.request.AskhelpRequest;
import com.bysj.service.IAskhelpService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.*;
import javax.annotation.Resource;


/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Askhelp", description = "求问表")
@RestController
@RequestMapping("askhelp")
public class AskhelpController {

    @Resource
    public IAskhelpService iAskhelpService;

    /**
     * 保存
     * @param askhelpRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "askhelp") @RequestBody AskhelpRequest askhelpRequest)throws Exception{
        iAskhelpService.saveAskhelp(askhelpRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param askhelpRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "askhelp")AskhelpRequest askhelpRequest)throws Exception{
        iAskhelpService.updateAskhelp(askhelpRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param askhelpQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "askhelp") AskhelpQuery askhelpQuery)throws Exception{
        return ActionResponse.success(iAskhelpService.findPageAskhelp(askhelpQuery));
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
    public ActionResponse queryById(@ApiParam(value = "askhelp") @PathVariable("id") Integer id)throws Exception{
        return ActionResponse.success(iAskhelpService.getById(id));
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
        return ActionResponse.success(iAskhelpService.deleteById(id));
    }
}

