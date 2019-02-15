package com.bysj.sawgger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * demo
 *
 * @author leo
 * @date 2018-07-09 9:48 AM
 **/
@RestController
@Api(value = "首页", description = "首页")
public class ApiDemo {

    @ApiOperation(value = "API 页面", notes = "接口列表")
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public void api(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }


}
