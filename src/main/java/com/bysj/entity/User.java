package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

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

    @ApiModelProperty("用户昵称")
    private String nickname;
    @ApiModelProperty("用户密码")
    private String psw;
    @ApiModelProperty("用户积分数")
    private Integer money;
    @ApiModelProperty("是否被封禁")
    private Integer ifBan;
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("用户头像")
    private String picture;
    /**
     * 用户权限
     */
    @ApiModelProperty("用户权限")
    private Integer level;
    @ApiModelProperty("注册时间")
    private Date registTime;

    @ApiModelProperty("性别")
    private Integer sex;

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"psw\":\"")
                .append(psw).append('\"');
        sb.append(",\"money\":")
                .append(money);
        sb.append(",\"ifBan\":")
                .append(ifBan);
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"picture\":\"")
                .append(picture).append('\"');
        sb.append(",\"level\":")
                .append(level);
        sb.append(",\"registTime\":\"")
                .append(registTime).append('\"');
        sb.append(",\"sex\":")
                .append(sex);
        sb.append('}');
        return sb.toString();
    }
}