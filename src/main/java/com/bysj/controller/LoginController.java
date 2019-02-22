package com.bysj.controller;

import com.bysj.entity.User;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Api(value = "login", description = "登录测试")
@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String getLogin(Model model, @RequestBody User user) {
        if ("970009721@qq.com".equals(user.getEmail())) {
            model.addAttribute("info", "登陆成功");
            return "login";
        }
        model.addAttribute("info", "登陆失败");
        return "login";
    }

    @GetMapping(value = "/login")
    public String getloginPage() {
        return "login";
    }
    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }

}
