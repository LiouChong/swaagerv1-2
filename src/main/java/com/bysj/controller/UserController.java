package com.bysj.controller;


import com.bysj.common.exception.BussinessException;
import com.bysj.common.response.ActionResponse;
import com.bysj.common.utils.MailUtil;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.request.UserRequestForRegist;
import com.bysj.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;


/**
 *
 * @author lc
 * @since 2019-01-10
 */
@Api(value = "User", description = "用户表")
@RestController
@RequestMapping("/v1/bbs/user")
public class UserController {

    @Resource
    public IUserService iUserService;

    @GetMapping(value = "/sendMail")
    public String sendVerificationCode(@RequestParam("mail") String email, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //生成随机码
        int verificationCode  = new Random().nextInt(10000);
        if (verificationCode < 1000)
            verificationCode += 1000;

        HttpSession session = request.getSession();
        //将随机生成的验证码保存到session的verificationCode中，便于后面取出对比
        session.setAttribute("verificationCode",verificationCode);
        session.setAttribute("email",email);
        try {
            MailUtil.senMail(verificationCode,email);
        } catch (Exception e) {
            throw new BussinessException("500","服务器发送邮件发生故障！请稍后再试");
        }

        return "sucess";
    }


    /**
     * 保存用户信息，用于用户注册界面
     * @param userRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "user") @RequestBody UserRequestForRegist userRequest, HttpServletRequest request)throws Exception{
        // @todo: 处理异常类
        String registInfo = iUserService.saveUser(userRequest, request);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param userRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "user") UserRequest userRequest)throws Exception{
        iUserService.updateUser(userRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param userQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "user") UserQuery userQuery)throws Exception{
        return ActionResponse.success(iUserService.findPageUser(userQuery));
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
    public ActionResponse queryById(@ApiParam(value = "user") @PathVariable("id") Integer id)throws Exception{

        return ActionResponse.success(iUserService.getById(id));
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

        return ActionResponse.success(iUserService.deleteById(id));
    }
}

