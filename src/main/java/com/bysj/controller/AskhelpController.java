package com.cuit.bbs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.*;
import com.antiy.common.base.ActionResponse;
import javax.annotation.Resource;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.QueryCondition;
import com.antiy.common.utils.ParamterExceptionUtils;

import com.cuit.bbs.service.IAskhelpService;
import com.cuit.bbs.entity.Askhelp;
import com.cuit.bbs.entity.vo.request.AskhelpRequest;
import com.cuit.bbs.entity.vo.response.AskhelpResponse;
import com.cuit.bbs.entity.vo.query.AskhelpQuery;


/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Askhelp", description = "求问表")
@RestController
@RequestMapping("/v1/bbs/askhelp")
public class AskhelpController {
    private static final Logger logger = LogUtils.get();

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
        ParamterExceptionUtils.isNull(id, "ID不能为空");
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
        ParamterExceptionUtils.isNull(id, "ID不能为空");
        return ActionResponse.success(iAskhelpService.deleteById(id));
    }
}

