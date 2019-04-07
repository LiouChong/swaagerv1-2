package com.bysj.controller;


import com.bysj.common.response.ActionResponse;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.PageUtil;
import com.bysj.common.utils.UserHandle;
import com.bysj.entity.vo.query.FollowQuery;
import com.bysj.entity.vo.request.FollowRequest;
import com.bysj.entity.vo.response.FollowResponse;
import com.bysj.enums.FollowEnum;
import com.bysj.service.IFollowService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedList;

/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Follow", description = "关注人表")
@RestController
@RequestMapping("/follow")
public class FollowController {


    @Resource
    public IFollowService iFollowService;

    @Autowired
    private UserHandle userHandle;


    /**
     * 保存
     * @param followRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public String saveSingle(@ApiParam(value = "follow") @RequestBody FollowRequest followRequest)throws Exception{
        if (iFollowService.saveFollow(followRequest) == 1) {
            return "关注成功";
        } else  {
            return "服务器异常，请稍后再试！";
        }
    }

    /**
     * 修改
     * @param followRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "follow")FollowRequest followRequest)throws Exception{
        iFollowService.updateFollow(followRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param followQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ModelAndView queryList( FollowQuery followQuery, ModelAndView modelAndView)throws Exception{
        PageResult<FollowResponse> pageFollow = iFollowService.findPageFollow(followQuery);
        // 如果返回值不为空才进行字符串操作，否则会报空指针异常
        if (pageFollow.getItems() != null || pageFollow.getItems().size() != 0) {
            pageFollow.getItems().forEach(item -> {
                item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
            });
            modelAndView.addObject("follows", pageFollow.getItems());
        } else {
            modelAndView.addObject("follows", new LinkedList<>());
        }

        if (followQuery.getType().equals(FollowEnum.QUERY_FAN.getCode())) {
            modelAndView.addObject("type","getFan");
        } else {
            modelAndView.addObject("type","getStar");
        }

        modelAndView.addObject("totalRecords", pageFollow.getTotalRecords());
        modelAndView.addObject("currentPage", pageFollow.getCurrentPage());
        // 如果fanId不等于null，则代表通过fanId查询自己关注的人，为了前端页面的分页，所以将fanId返回给前端
        if (followQuery.getFanId() != null) {
            modelAndView.addObject("fanId", followQuery.getFanId());
        } else {
            modelAndView.addObject("fanId", -1);
        }
        modelAndView.addObject("totalPage", PageUtil.getTotalPage(pageFollow.getTotalRecords(),pageFollow.getPageSize()));

        modelAndView.setViewName("follow_user");

        return modelAndView;
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
    public ActionResponse queryById(@ApiParam(value = "follow") @PathVariable("id") Integer id)throws Exception{

        return ActionResponse.success(iFollowService.getById(id));
    }

    /**
     * 通过ID删除
     * @param followRequest
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteById(@ApiParam(value = "id") @RequestBody FollowRequest followRequest)throws Exception{
        if (iFollowService.cancelFollow(followRequest) == 1) {
            return "取消成功！";
        } else {
            return "服务器异常！请稍后再试";
        }
    }
}

