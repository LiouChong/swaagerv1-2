package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * PermissionRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class PermissionRequest   {

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

}