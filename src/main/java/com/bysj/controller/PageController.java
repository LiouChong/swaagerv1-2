package com.bysj.controller;

import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.NumberChineseEx;
import com.bysj.common.utils.UserHandle;
import com.bysj.entity.vo.query.ManagePostQuery;
import com.bysj.entity.vo.query.UserQueryByLevel;
import com.bysj.entity.vo.response.ApplyPlateResponse;
import com.bysj.entity.vo.response.PostBanResponse;
import com.bysj.entity.vo.response.UserBanResponse;
import com.bysj.entity.vo.response.UserLevellResponse;
import com.bysj.service.IApplyPlateService;
import com.bysj.service.IPostService;
import com.bysj.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

/**
 * @Author: 刘冲
 * @Description:
 * @Date: 2019/3/4 22:20
 */
@Controller
public class PageController {
    @Autowired
    private UserHandle userHandle;

    @Autowired
    private IApplyPlateService applyPlateService;

    @Autowired
    private IUserService userService;

    @Autowired
    private NumberChineseEx numberChineseEx;

    @Autowired
    private IPostService postService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/backstage/manage")
    @RequiresPermissions("user:ban")
    public String getManagePage(Model model) throws Exception {
        model.addAttribute("ApplyPlate", getApplyPlate());
        model.addAttribute("platers", getPlater());
        model.addAttribute("banPosts", getBanPost());
        model.addAttribute("banUsers", getBanUser());
        return "manage";
    }

    /**
     * 获取申请版主列表
     * @return
     * @throws Exception
     */
    private PageResult<ApplyPlateResponse> getApplyPlate() throws Exception {
        // 查询申请博主列表
        PageResult<ApplyPlateResponse> pageApplyPlate = applyPlateService.findPageApplyPlate(new ObjectQuery());
        pageApplyPlate.getItems().forEach(item -> {
            item.setApplyTimeStr(DateUtils.getDataString(item.getApplyTime(), DateUtils.NO_TIME_FORMAT));
        });
        return pageApplyPlate;
    }

    /**
     * 获取版主列表
     * @return
     */
    private PageResult<UserLevellResponse> getPlater() {
        // 查询博主列表，将登记设置为2（博主等级）
        UserQueryByLevel userQuery = new UserQueryByLevel();
        userQuery.setUserLevel(2);
        PageResult<UserLevellResponse> userByLevel = userService.findUserByLevel(userQuery);
        Calendar calendar = Calendar.getInstance();
        userByLevel.getItems().forEach(item-> {
            // 给任职天数赋值、转换时间为字符串、级别转换
            calendar.setTime(item.getPlaterGmtCreate());
            item.setManageTime(Calendar.getInstance().getWeekYear() - calendar.get(Calendar.YEAR));
            item.setUserGmtCreateStr(DateUtils.getDataString(item.getUserGmtCreate(),DateUtils.WHOLE_FORMAT));
            item.setPlaterGmtCreateStr(DateUtils.getDataString(item.getPlaterGmtCreate(),DateUtils.WHOLE_FORMAT));
            item.setLevelStr(numberChineseEx.numExchangeChinese(item, "level"));
        });
        return userByLevel;
    }

    /**
     * 获取被ban用户列表
     * @return
     */
    private PageResult<PostBanResponse> getBanPost() {
        ManagePostQuery managePostQuery = new ManagePostQuery();
        managePostQuery.setIfBan(1);
        // 查询被封禁帖子列表
        PageResult<PostBanResponse> pageBanPost = postService.findManagePagePost(managePostQuery);
        return pageBanPost;
    }

    /**
     * 获取被封禁用户
     * @return
     */
    private PageResult<UserBanResponse> getBanUser() {
        // 查询被封禁用户列表
        PageResult<UserBanResponse> pageBanUser = userService.findPageUserBan(new ObjectQuery());
        return pageBanUser;
    }

}
