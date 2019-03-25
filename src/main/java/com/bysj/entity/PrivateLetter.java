package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 私信表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class PrivateLetter extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 发送者id（用于创建者）
     */
    @ApiModelProperty("发送者id（用于创建者）")
    private Integer userSendSend;

    /**
     * 接收者id
     */
    @ApiModelProperty("接收者id")
    private Integer userSendRev;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;
    /**
     * 是否已读:1 已读,0 未读
     */
    @ApiModelProperty("是否已读:1 已读,0 未读")
    private Integer ifRead;
    /**
     * 状态:1 有效,0 无效
     */
    @ApiModelProperty("状态:1 有效,0 无效")
    private Integer state;
    /**
     * 修改着id
     */
    @ApiModelProperty("修改着id")
    private Integer userModify;
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
     * 私信类型:1 用户私信,2 系统私信
     */
    @ApiModelProperty("私信类型:1 用户私信,2 系统私信")
    private Integer letterType;
    /**
     * 发送者id（用于接收者）
     */
    @ApiModelProperty("发送者id（用于接收者）")
    private Integer userRevSend;


    public Integer getUserSendSend() {
        return userSendSend;
    }

    public void setUserSendSend(Integer userSendSend) {
        this.userSendSend = userSendSend;
    }


    public Integer getUserSendRev() {
        return userSendRev;
    }

    public void setUserSendRev(Integer userSendRev) {
        this.userSendRev = userSendRev;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getIfRead() {
        return ifRead;
    }

    public void setIfRead(Integer ifRead) {
        this.ifRead = ifRead;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public Integer getUserModify() {
        return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
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


    public Integer getLetterType() {
        return letterType;
    }

    public void setLetterType(Integer letterType) {
        this.letterType = letterType;
    }


    public Integer getUserRevSend() {
        return userRevSend;
    }

    public void setUserRevSend(Integer userRevSend) {
        this.userRevSend = userRevSend;
    }


    @Override
    public String toString() {
        return "PrivateLetter{" +
                "id=" + super.getId() +
                ", userSendSend=" + userSendSend +
                ", userSendRev=" + userSendRev +
                ", content=" + content +
                ", ifRead=" + ifRead +
                ", state=" + state +
                ", userModify=" + userModify +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", letterType=" + letterType +
                ", userRevSend=" + userRevSend +
                "}";
    }
}