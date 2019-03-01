package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * PrivateLetterRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class PrivateLetterRequest  {

    /**
     *  发送者id（用于创建者）
     */
    @ApiModelProperty("发送者id（用于创建者）")
    private Integer userSendSend;
    /**
     *  接收者id
     */
    @ApiModelProperty("接收者id")
    private Integer userSendRev;
    /**
     *  内容
     */
    @ApiModelProperty("内容")
    private String content;
    /**
     *  是否已读: 1已读 0 未读
     */
    @ApiModelProperty("是否已读: 1已读 0 未读")
    private Boolean ifRead;
    /**
     *  状态： 1有效 0无效
     */
    @ApiModelProperty("状态： 1有效 0无效")
    private Integer state;
    /**
     *  修改着id
     */
    @ApiModelProperty("修改着id")
    private Integer userModify;
    /**
     *  创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     *  修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;
    /**
     *  私信类型： 1 用户私信 2 系统私信
     */
    @ApiModelProperty("私信类型： 1 用户私信 2 系统私信")
    private Integer letterType;
    /**
     *  发送者id（用于接收者）
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


    public Boolean getIfRead() {
    return ifRead;
    }

    public void setIfRead(Boolean ifRead) {
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




}