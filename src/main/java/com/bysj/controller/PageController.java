package com.bysj.controller;

import com.bysj.common.utils.UserHandle;
import com.bysj.entity.vo.response.UserResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 刘冲
 * @Description:
 * @Date: 2019/3/4 22:20
 */
@Controller
public class PageController {
    @Autowired
    private UserHandle userHandle;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/backstage/manage")
    @RequiresPermissions("user:ban")
    public String getManagePage() {
        return "manage";
    }
}
