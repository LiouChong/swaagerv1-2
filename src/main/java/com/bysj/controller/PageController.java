package com.bysj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 刘冲
 * @Description:
 * @Date: 2019/3/4 22:20
 */
@Controller
public class PageController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
