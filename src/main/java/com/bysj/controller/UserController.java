package com.bysj.controller;


import com.bysj.common.response.ActionResponse;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.query.UserRequestForLogin;
import com.bysj.entity.vo.query.UserRequestForRegist;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.request.UserRequestForUpdate;
import com.bysj.entity.vo.response.UserResponse;
import com.bysj.service.IUserService;
import com.google.common.primitives.Booleans;
import io.swagger.annotations.*;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.codec.multipart.Part;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Map;

/**
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "User", description = "用户表")
@RestController
public class UserController {


    /**
     * 发送邮件
     *
     * @param map
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/user/sendMail")
    public String sendEmail(@RequestBody Map map, HttpServletRequest request) throws IOException {
        return iUserService.sendVerificationCode(map, request);
    }

    @Resource
    public IUserService iUserService;


    /**
     * 检查邮箱是否重名
     */
    @PostMapping(value = "/user/checkName")
    public String checkIfRepeatName(String email) {
        if (iUserService.ifRepeatEmail(email)) {
            return "邮箱已被注册！";
        } else {
            return "邮箱可以使用！";
        }
    }


    /**
     * 保存用户信息，用于用户注册界面
     *
     * @param userRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/regist", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "user_picture") @RequestBody UserRequestForRegist userRequest, HttpServletRequest request) throws Exception {
        // @todo: 处理异常类
        return iUserService.saveUser(userRequest, request);
    }

    /**
     * 用户登录操作
     *
     * @param userRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @PostMapping(value = "/login")
    public ModelAndView doLogin(UserRequestForLogin userRequest,ModelAndView modelAndView, HttpServletRequest request) throws Exception {
        ActionResponse actionResponse = iUserService.doLogin(userRequest, request);

        String successUrl = null;
        if ("登陆成功".equals(actionResponse.getBody())) {
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
            // 如果shiro保存的有上次请求并且不为"/"，则返回上次请求页面，否则跳转到首页。
            if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase("GET")) {
                if (!("/".equals(savedRequest.getRequestUrl()))) {
                    successUrl = savedRequest.getRequestUrl();
                    System.out.println("url======>> " + successUrl);
                } else {
                    successUrl = "post/index";
                }
            } else {
                successUrl = "post/index";
            }

            return new ModelAndView("redirect:" + successUrl);
        } else {
            if (actionResponse.getBody() != null) {
                modelAndView.addObject("login_info", actionResponse.getBody().toString());
            } else if (actionResponse.getHead() != null) {
                modelAndView.addObject("login_info", String.valueOf(actionResponse.getHead()));
            }
        }
        modelAndView.setViewName("/login");
        return modelAndView;
    }


    /**
     * 修改
     *
     * @param userRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Integer updateSingle(@ApiParam(value = "user_picture")@RequestBody UserRequestForUpdate userRequest) throws Exception {
        return iUserService.updateUser(userRequest);
    }

    /**
     * 批量查询
     *
     * @param userQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "user_picture") UserQuery userQuery) throws Exception {
        return ActionResponse.success(iUserService.findPageUser(userQuery));
    }

    /**
     * 查询用户详细信息
     *
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID查询", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView queryById(@PathVariable(value = "id") Integer id, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("user",iUserService.getInfoById(id));
        modelAndView.setViewName("myInfo");
        return modelAndView;
    }

    /**
     * 查询当前用户详细信息
     *
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID查询", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserInfo(ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("user",iUserService.getCurrentUserInfo());
        modelAndView.setViewName("myInfo");
        return modelAndView;
    }

    /**
     * 通过ID删除
     *
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public ActionResponse deleteById(@ApiParam(value = "id") @PathVariable("id") Integer id) throws Exception {

        return ActionResponse.success(iUserService.deleteById(id));
    }

    /**
     * 上传头像
     *
     * @param
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/picture", method = RequestMethod.POST)
    public void addPicture(@RequestPart("file") MultipartFile profilePicture, ModelAndView model, HttpServletRequest request) throws Exception {
        iUserService.addPicture(profilePicture, model, request);
    }

}

