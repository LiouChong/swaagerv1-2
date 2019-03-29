package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * PrivateLetterRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PrivateLetterRequest {

    private Integer id;
    /**
     * 接收者id
     */
    @ApiModelProperty("接收者id(用于发送方)")
    private Integer userSendRev;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;

    /**
     * 操作的类型
     */
    private String operation;
    /**
     * 发送者id（用于接收者），用于接收者删除私信，将发送者id设置为0
     */
    private Integer userRevSend;

    private Integer ifRead;

    public Integer getUserSendRev() {
        return userSendRev;
    }

    public void setUserSendRev(Integer userSendRev) {
        this.userSendRev = userSendRev;
    }

    public Integer getUserRevSend() {
        return userRevSend;
    }

    public Integer getIfRead() {
        return ifRead;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setIfRead(Integer ifRead) {
        this.ifRead = ifRead;
    }

    public void setUserRevSend(Integer userRevSend) {
        this.userRevSend = userRevSend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}