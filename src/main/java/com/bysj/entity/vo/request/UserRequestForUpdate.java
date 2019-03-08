package com.bysj.entity.vo.request;

import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * UserRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class UserRequestForUpdate extends BaseEntity {

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
     * 个性签名
     */
    @ApiModelProperty("个性签名")
    private String signaTure;
    /**
     * 性别:1 男,2 女
     */
    @ApiModelProperty("性别:1 男,0 女")
    private Integer sex;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

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

    /**
     * 旧密码
     */
    private String oldPswValue;

    public String getOldPswValue() {
        return oldPswValue;
    }

    public void setOldPswValue(String oldPswValue) {
        this.oldPswValue = oldPswValue;
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


    public String getSignaTure() {
        return signaTure;
    }

    public void setSignaTure(String signaTure) {
        this.signaTure = signaTure;
    }


    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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
        sb.append(",\"signaTure\":\"")
                .append(signaTure).append('\"');
        sb.append(",\"sex\":")
                .append(sex);
        sb.append(",\"age\":")
                .append(age);
        sb.append('}');
        return sb.toString();
    }
}