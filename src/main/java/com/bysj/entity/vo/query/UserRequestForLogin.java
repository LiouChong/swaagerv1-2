package com.bysj.entity.vo.query;

import io.swagger.annotations.ApiModelProperty;

/**
 * 描述:
 *
 * @author liuchong
 */
public class UserRequestForLogin {

    @ApiModelProperty("用户密码")
    private String psw;

    @ApiModelProperty("用户邮箱")
    private String email;


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
        sb.append('}');
        return sb.toString();
    }
}
