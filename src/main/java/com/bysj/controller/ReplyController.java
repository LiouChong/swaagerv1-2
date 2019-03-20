package com.bysj.controller;


import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.ReplyQuery;
import com.bysj.entity.vo.request.ReplyDelRequest;
import com.bysj.entity.vo.request.ReplyRequest;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.service.IReplyService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Reply", description = "回复表")
@RestController
@RequestMapping("/reply")
public class ReplyController {


    @Resource
    public IReplyService iReplyService;

    /**
     * 发表回复
     * @param replyRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    @RequiresAuthentication
    public ModelAndView saveSingle(@ApiParam(value = "reply")ReplyRequest replyRequest,ModelAndView modelAndView)throws Exception{
        iReplyService.saveReply(replyRequest);
        modelAndView.setViewName("redirect:/post/detail?postId=" + replyRequest.getPostId());
        return modelAndView;
    }

    /**
     * 删除评论
     * @param replyRequest
     * @return actionResponse
     */
    @ApiOperation(value = "/update/single", notes = "传入实体对象信息")
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    @Transactional
    public String updateSingle(@ApiParam(value = "reply") @RequestBody ReplyDelRequest replyRequest)throws Exception{
        return iReplyService.updateReply(replyRequest);
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

}

