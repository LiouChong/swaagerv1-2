package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * UserBanResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class UserBanResponse extends BaseEntity {
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 创建时间
     */
    private String gmtCreate;

    /**
     * 封禁时间
     */
    private String gmtModify;

    /**
     * 封禁理由
     */
    private String banReason;

    /**
     * 处理人
     */
    private String banUserName;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGmtCreate() {
        return gmtCreate.substring(0, gmtCreate.lastIndexOf("."));
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModify() {
        return gmtModify.substring(0, gmtModify.lastIndexOf("."));
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public String getBanUserName() {
        return banUserName;
    }

    public void setBanUserName(String banUserName) {
        this.banUserName = banUserName;
    }
}