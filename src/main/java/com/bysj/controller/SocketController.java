package com.bysj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 *
 * @author liuchong
 */
@Controller
public class SocketController {

    @RequestMapping("/socket")
    public String getSocketPage() {
        return "socketDemo";
    }
}
