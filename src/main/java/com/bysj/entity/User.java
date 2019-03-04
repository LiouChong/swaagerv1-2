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
     * 性别:1 男,2 女
     */
    @ApiModelProperty("性别:1 男,2 女")
    private Boolean sex;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 状态，1 有效0 无效
     */
    @ApiModelProperty("状态:1 有效,0 无效")
    private Integer state;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;

    /**
     * 修改者id
     */
    @ApiModelProperty("修改者id")
    private Integer userModify;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getUserModify() {
        return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"psw\":\"")
                .append(psw).append('\"');
        sb.append(",\"money\":")
                .append(money);
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"picture\":\"")
                .append(picture).append('\"');
        sb.append(",\"level\":")
                .append(level);
        sb.append(",\"signaTure\":\"")
                .append(signaTure).append('\"');
        sb.append(",\"sex\":")
                .append(sex);
        sb.append(",\"age\":")
                .append(age);
        sb.append(",\"state\":")
                .append(state);
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"userModify\":")
                .append(userModify);
        sb.append('}');
        return sb.toString();
    }
}