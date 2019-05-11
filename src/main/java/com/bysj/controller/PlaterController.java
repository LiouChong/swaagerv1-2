package com.bysj.controller;


import com.bysj.common.exception.BussinessException;
import com.bysj.common.response.ActionResponse;
import com.bysj.service.IPlaterService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "Plater", description = "板块表")
@RestController
@RequestMapping("/plater")
public class PlaterController {

    @Resource
    public IPlaterService iPlaterService;


    @GetMapping("/takeOff")
    public ActionResponse takeOffPlater(Integer plateId) {
        if (iPlaterService.takeOffPlate(plateId) == 1) {
            return ActionResponse.success();
        } else {
            throw new BussinessException("服务器异常，请稍后再试!");
        }
    }
}

