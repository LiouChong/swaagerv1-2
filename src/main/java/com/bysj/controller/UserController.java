package com.bysj.controller;


import com.bysj.common.exception.BussinessException;
import com.bysj.common.response.ActionResponse;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.PageUtil;
import com.bysj.common.utils.UserHandle;
import com.bysj.entity.Follow;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.*;
import com.bysj.entity.vo.request.GiveUserRequest;
import com.bysj.entity.vo.request.UserRequestForBan;
import com.bysj.entity.vo.request.UserRequestForUpdate;
import com.bysj.entity.vo.response.*;
import com.bysj.service.*;
import io.swagger.annotations.*;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "User", description = "用户表")
@RestController
public class UserController {

    @Autowired
    UserHandle userHandle;
    @Autowired
    private IPrivateLetterService privateLetterService;

    @Autowired
    private IPostService postService;

    @Autowired
    private IFollowService followService;

    @Autowired
    private ITeamInviteService teamInviteService;

    @Autowired
    private IAskhelpService askhelpService;

    @Autowired
    private ITeamService teamService;

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
    public ModelAndView doLogin(UserRequestForLogin userRequest, ModelAndView modelAndView, HttpServletRequest request) throws Exception {
        ActionResponse actionResponse = iUserService.doLogin(userRequest, request);

        String successUrl = null;
        if ("登陆成功".equals(actionResponse.getBody())) {
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
            // 如果shiro保存的有上次请求并且不为"/"，则返回上次请求页面，否则跳转到首页。
            if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase("GET")) {
                if (!("/".equals(savedRequest.getRequestUrl()) || savedRequest.getRequestUrl().contains("/css/"))) {
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
    public Integer updateSingle(@ApiParam(value = "user_picture") @RequestBody UserRequestForUpdate userRequest) throws Exception {
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
     * @param queryForList
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID查询", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/other", method = RequestMethod.GET)
    public ModelAndView queryById(PostQueryForList queryForList) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        Integer userId = queryForList.getUserId();

        // 获取详细信息
        UserResponse infoById = iUserService.getInfoById(userId);

        // 查询是否关注该用户
        Follow byIds = followService.getByIds(userId);

        // 判断当前用户是否关注该用户
        if (Objects.isNull(byIds)) {
            modelAndView.addObject("followIf", null);
        } else {
            modelAndView.addObject("followIf", byIds);
        }

        // 查询该用户发帖
        List<PostResponse> userPosts = postService.findPagePost(queryForList, "follow");

        // 查询用户发帖数量
        Integer postCount = postService.findPagePostCount(queryForList);

        // 获得总页数
        Integer totalPage = PageUtil.getTotalPage(postCount, queryForList.getPageSize());

        modelAndView.addObject("totalPage", totalPage);
        modelAndView.addObject("currentPage", queryForList.getCurrentPage());
        modelAndView.addObject("posts", userPosts);
        modelAndView.addObject("postCount", postCount);
        modelAndView.addObject("user", infoById);
        modelAndView.setViewName("UserInfo");
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
    @RequiresAuthentication
    public ModelAndView getUserInfo(ModelAndView modelAndView) throws Exception {
        if (userHandle.getUserId() == null) {
            modelAndView.setViewName("/login");
            return modelAndView;
        }
        modelAndView.addObject("user", iUserService.getCurrentUserInfo(userHandle.getUserId()));
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
    @ApiOperation(value = "上传头像", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/picture", method = RequestMethod.POST)
    public ModelAndView addPicture(@RequestPart("file") MultipartFile profilePicture, ModelAndView model, HttpServletRequest request) throws Exception {
        String info = iUserService.addPicture(profilePicture, request);
        model.addObject("info", info);
        model.setViewName("redirect:/user");
        return model;
    }

    /**
     * 封禁用户
     *
     * @param
     * @return actionResponse
     */
    @ApiOperation(value = "通过用户id封禁用户", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/ban", method = RequestMethod.POST)
    public String banUser(@RequestBody UserRequestForBan userRequestForBan) throws Exception {
        return iUserService.banUser(userRequestForBan);
    }

    /**
     * 获得个人用户管理页面
     *
     * @param
     * @return actionResponse
     */
    @ApiOperation(value = "个人用户管理页面", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/user/myManage", method = RequestMethod.GET)
    @RequiresAuthentication
    public ModelAndView manageMyInfo(ModelAndView modelAndView) throws Exception {
        // 为 查询我发送的私信变量赋值
        PrivateLetterForMyManageQuery query = new PrivateLetterForMyManageQuery();
        modelAndView.addObject("myPost", getMySendPost());
        modelAndView.addObject("sendLetter", getMySendLetter(query));
        modelAndView.addObject("revLetter", getMyRevLetter(query));
        modelAndView.addObject("invites", getMyTeamInvite());
        modelAndView.addObject("invitesCount", getTeamInviteCount());
        modelAndView.addObject("askHelps", getAksHelpList());
        modelAndView.addObject("myTeams", getMyTeam());
        modelAndView.addObject("userId", userHandle.getUserId());
        modelAndView.setViewName("my_manage");
        return modelAndView;
    }


    /**
     * 查询我发送的私信信息
     *
     * @param query
     * @return
     */
    private PageResult<PrivateLetterForMyResponse> getMySendLetter(PrivateLetterForMyManageQuery query) {
        Integer userId = userHandle.getUserId();
        if (Objects.isNull(userId)) {
            throw new UnauthenticatedException();
        }
        query.setUserSendSend(userId);

        PageResult<PrivateLetterForMyResponse> pageForMySend = privateLetterService.findPageForMyManage(query);
        return pageForMySend;
    }

    /**
     * 查询我接受的私信的信息
     *
     * @param query
     * @return
     */
    private PageResult<PrivateLetterForMyResponse> getMyRevLetter(PrivateLetterForMyManageQuery query) {
        // 我收到的私信的查询变量设置
        query.setUserSendSend(null);
        query.setUserSendRev(userHandle.getUserId());


        PageResult<PrivateLetterForMyResponse> pageForMyRev = privateLetterService.findPageForMyManage(query);
        return pageForMyRev;
    }

    /**
     * 查询我发送的帖子
     *
     * @return
     */
    private PageResult<PostBanResponse> getMySendPost() {
        ManagePostQuery managePostQuery = new ManagePostQuery();
        managePostQuery.setOwnerId(userHandle.getUserId());

        PageResult<PostBanResponse> managePagePost = postService.findManagePagePost(managePostQuery);
        return managePagePost;
    }

    /**
     * 查询我接受的讨论组邀请
     *
     * @return
     */
    private List<TeamInviteMResponse> getMyTeamInvite() {
        return teamInviteService.getMyTeamInvite();
    }

    /**
     * 查询讨论组邀请数量
     *
     * @return
     */
    private Integer getTeamInviteCount() {
        return teamInviteService.getTeamInviteCount();
    }

    private List<AskHelpManageResponse> getAksHelpList() {
        List<AskHelpManageResponse> userManageList = askhelpService.findUserManageList();
        return userManageList;
    }

    private List<TeamIndexResponse> getMyTeam() {
        List<TeamIndexResponse> teamIndexResponse = teamService.selectForIndex(userHandle.getUserId());
        return teamIndexResponse;
    }


    /**
     * 对帖子进行结帖时给用户的积分数
     *
     * @param
     * @return actionResponse
     */
    @RequestMapping(value = "/user/giveMoney", method = RequestMethod.POST)
    public ActionResponse giveUserMonry(GiveUserRequest request) throws Exception {
        User user = new User();
        user.setId(request.getUserId());
        user.setMoney(user.getMoney() + request.getMoney());
        user.setGmtModify(new Date());
        user.setUserModify(userHandle.getUserId());
        if (iUserService.update(user) == 1) {
            return ActionResponse.success();
        } else {
            throw new BussinessException("服务器错误，请稍后再试！");
        }
    }
}

