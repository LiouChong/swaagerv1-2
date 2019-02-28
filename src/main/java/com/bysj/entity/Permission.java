package com.bysj.entity;


import java.util.Date;
import com.antiy.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 权限表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class Permission extends BaseEntity {


private static final long serialVersionUID = 1L;

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
    public String toString() {
            return "Permission{" +
                                                                                            ", roleId=" + roleId +
                                                                                        ", permission=" + permission +
                                                "}";
    }
    }