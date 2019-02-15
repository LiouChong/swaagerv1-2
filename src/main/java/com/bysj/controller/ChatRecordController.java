package com.bysj.controller;

import com.bysj.common.ActionResponse;
import com.bysj.entity.vo.query.ChatRecordQuery;
import com.bysj.entity.vo.request.ChatRecordRequest;
import com.bysj.service.IChatRecordService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 *
 * @author lc
 * @since 2019-01-10
 */
@Api(value = "ChatRecord", description = "聊天记录表")
@RestController
@RequestMapping("/v1/bbs/chatrecord")
public class ChatRecordController {

    @Resource
    public IChatRecordService iChatRecordService;

    /**
     * 保存
     * @param chatRecordRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "chatRecord") @RequestBody ChatRecordRequest chatRecordRequest)throws Exception{
        iChatRecordService.saveChatRecord(chatRecordRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param chatRecordRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "chatRecord")ChatRecordRequest chatRecordRequest)throws Exception{
        iChatRecordService.updateChatRecord(chatRecordRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param chatRecordQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "chatRecord") ChatRecordQuery chatRecordQuery)throws Exception{
        return ActionResponse.success(iChatRecordService.findPageChatRecord(chatRecordQuery));
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
    public ActionResponse queryById(@ApiParam(value = "chatRecord") @PathVariable("id") Integer id)throws Exception{
        return ActionResponse.success(iChatRecordService.getById(id));
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
        return ActionResponse.success(iChatRecordService.deleteById(id));
    }
}

