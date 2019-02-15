package com.bysj.controller;


import com.bysj.common.ActionResponse;
import com.bysj.entity.vo.query.TlevelQuery;
import com.bysj.entity.vo.request.TlevelRequest;
import com.bysj.service.ITlevelService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



/**
 *
 * @author lc
 * @since 2019-01-10
 */
@Api(value = "Tlevel", description = "角色表")
@RestController
@RequestMapping("/v1/bbs/tlevel")
public class TlevelController {

    @Resource
    public ITlevelService iTlevelService;

    /**
     * 保存
     * @param tlevelRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "tlevel") @RequestBody TlevelRequest tlevelRequest)throws Exception{
        iTlevelService.saveTlevel(tlevelRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param tlevelRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "tlevel")TlevelRequest tlevelRequest)throws Exception{
        iTlevelService.updateTlevel(tlevelRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param tlevelQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "tlevel") TlevelQuery tlevelQuery)throws Exception{
        return ActionResponse.success(iTlevelService.findPageTlevel(tlevelQuery));
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
    public ActionResponse queryById(@ApiParam(value = "tlevel") @PathVariable("id") Integer id)throws Exception{

        return ActionResponse.success(iTlevelService.getById(id));
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

        return ActionResponse.success(iTlevelService.deleteById(id));
    }
}

