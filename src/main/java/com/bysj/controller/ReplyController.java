package com.bysj.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.*;
import com.bysj.common.base.ActionResponse;
import javax.annotation.Resource;
import com.bysj.common.utils.LogUtils;
import com.bysj.common.base.QueryCondition;
import com.bysj.common.utils.ParamterExceptionUtils;

import com.cuit.bbs.service.IReplyService;
import com.cuit.bbs.entity.Reply;
import com.cuit.bbs.entity.vo.request.ReplyRequest;
import com.cuit.bbs.entity.vo.response.ReplyResponse;
import com.cuit.bbs.entity.vo.query.ReplyQuery;


/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Reply", description = "回复表")
@RestController
@RequestMapping("/v1/bbs/reply")
public class ReplyController {


    @Resource
    public IReplyService iReplyService;

    /**
     * 保存
     * @param replyRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "reply") @RequestBody ReplyRequest replyRequest)throws Exception{
        iReplyService.saveReply(replyRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param replyRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "reply")ReplyRequest replyRequest)throws Exception{
        iReplyService.updateReply(replyRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param replyQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "reply") ReplyQuery replyQuery)throws Exception{
        return ActionResponse.success(iReplyService.findPageReply(replyQuery));
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
    public ActionResponse queryById(@ApiParam(value = "reply") @PathVariable("id") Integer id)throws Exception{

        return ActionResponse.success(iReplyService.getById(id));
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

        return ActionResponse.success(iReplyService.deleteById(id));
    }
}

