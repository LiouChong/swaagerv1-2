package com.bysj.entity;

import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class User extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String psw;
    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer money;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String picture;
    /**
     * 用户权限
     */
    @ApiModelProperty("用户权限")
    private Integer level;
    /**
     * 个性签名
     */
    @ApiModelProperty("个性签名")
    private String signaTure;
    /**
     * 性别： 1 男 2 女
     */
    @ApiModelProperty("性别： 1 男 2 女")
    private Boolean sex;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;


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


    public String getSignaTure() {
        return signaTure;
    }

    public void setSignaTure(String signaTure) {
        this.signaTure = signaTure;
    }


    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                ", nickname=" + nickname +
                ", psw=" + psw +
                ", money=" + money +
                ", email=" + email +
                ", picture=" + picture +
                ", level=" + level +
                ", signaTure=" + signaTure +
                ", sex=" + sex +
                ", age=" + age +
                "}";
    }
}