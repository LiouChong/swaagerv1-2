package com.bysj.entity.vo.request;

import com.antiy.common.base.BasicRequest;
import io.swagger.annotations.ApiModelProperty;
import com.antiy.common.validation.ObjectValidator;
import com.antiy.common.exception.RequestParamValidateException;
/**
 * <p>
 * TlevelRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class TlevelRequest extends BasicRequest implements ObjectValidator{

    @ApiModelProperty("")
    private String role;



    public String getRole() {
    return role;
    }

    public void setRole(String role) {
        this.role = role;
        }


    @Override
    public void validate() throws RequestParamValidateException {

    }

}