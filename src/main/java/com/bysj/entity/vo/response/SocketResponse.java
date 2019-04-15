package com.bysj.entity.vo.response;

/**
 * 描述:
 *
 * @author liuchong
 */
public class SocketResponse {
    private String userName;
    private String sendTime;
    private String message;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
