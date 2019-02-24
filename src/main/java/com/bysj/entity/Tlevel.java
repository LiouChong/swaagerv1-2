package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class Tlevel extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Tlevel{" +
                ", role=" + role +
                "}";
    }
}