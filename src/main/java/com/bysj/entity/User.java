package com.bysj.entity;


import java.util.Date;

import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class User extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String nickname;
    @ApiModelProperty("")
    private String psw;
    @ApiModelProperty("")
    private Integer money;
    @ApiModelProperty("")
    private Integer ifBan;
    @ApiModelProperty("")
    private String email;
    @ApiModelProperty("")
    private String picture;
    /**
     * 用户权限
     */
    @ApiModelProperty("用户权限")
    private Integer level;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


    public Integer getIfBan() {
        return ifBan;
    }

    public void setIfBan(Integer ifBan) {
        this.ifBan = ifBan;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "User{" +
                ", nickname=" + nickname +
                ", psw=" + psw +
                ", money=" + money +
                ", ifBan=" + ifBan +
                ", email=" + email +
                ", picture=" + picture +
                ", level=" + level +
                "}";
    }
}