package com.bysj.entity.vo.request;

import com.antiy.common.base.BasicRequest;
import io.swagger.annotations.ApiModelProperty;
import com.antiy.common.validation.ObjectValidator;
import com.antiy.common.exception.RequestParamValidateException;
/**
 * <p>
 * PermissionRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class PermissionRequest extends BasicRequest implements ObjectValidator{

    @ApiModelProperty("")
    private Integer roleId;
    @ApiModelProperty("")
    private String permission;



    public Integer getRoleId() {
    return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
        }


    public String getPermission() {
    return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
        }


    @Override
    public void validate() throws RequestParamValidateException {

    }

}