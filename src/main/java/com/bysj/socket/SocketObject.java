package com.bysj.socket;

import io.swagger.models.auth.In;

/**
 * 描述:
 *
 * @author liuchong
 */
public class SocketObject {
    private Integer userId;
    private String message;
    private Integer teamId;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

}
