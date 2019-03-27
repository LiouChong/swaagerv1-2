package com.bysj.common.exception;

import com.bysj.common.response.ActionResponse;
import com.bysj.common.response.RespBasicCode;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * <p>
 * 自定义异常处理类
 * </p>
 *
 * @author lc
 * @since 2019-02-24
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    public ActionResponse BussinessExceptionHandler(BussinessException exception) {
        System.out.println("--------------------------->>> 进入异常处理类  -------> " + exception.getMessage());
        // 如果该异常没有异常信息，则返回默认的业务异常
        if (Objects.isNull(exception.getMessage())) {
            return ActionResponse.fail(RespBasicCode.BUSSINESS_EXCETION);
        } else {
            // 如果有异常信息，则返回异常信息
            return ActionResponse.fail(RespBasicCode.BUSSINESS_EXCETION, exception.getMessage());
        }
    }

    @ExceptionHandler(RequestParamsException.class)
    @ResponseBody
    public ActionResponse RequestParamsExceptionHandler(RequestParamsException exception) {
        System.out.println("--------------------------->>> 进入异常处理类 -------> " + exception.getMessage());
        // 如果该异常没有异常信息，则返回默认的业务异常
        if (Objects.isNull(exception.getMessage())) {
            return ActionResponse.fail(RespBasicCode.PARAMETER_ERROR);
        } else {
            // 如果有异常信息，则返回异常信息
            return ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, exception.getMessage());
        }
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public String redirectToLoginPage() {
        return "redirect:/login";
    }
}
