package com.bysj.entity.vo.query;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * UserRequest 请求对象
 * </p>
 *
 * @author lc
 * @since 2018-12-27
 */

public class UserRequestForRegist {

    @ApiModelProperty("用户密码")
    private String psw;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    @ApiModelProperty("邮箱验证码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"psw\":\"")
                .append(psw).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"code\":\"")
                .append(code).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
