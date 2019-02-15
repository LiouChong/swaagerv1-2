package com.bysj.entity;


import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 聊天记录表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class ChatRecord extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String content;
    @ApiModelProperty("")
    private Integer teamId;
    @ApiModelProperty("")
    private Integer fromUserId;
    @ApiModelProperty("")
    private String fromUserName;
    @ApiModelProperty("")
    private Date sendTime;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }


    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }


    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }


    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }


    @Override
    public String toString() {
        return "ChatRecord{" +
                ", content=" + content +
                ", teamId=" + teamId +
                ", fromUserId=" + fromUserId +
                ", fromUserName=" + fromUserName +
                ", sendTime=" + sendTime +
                "}";
    }
}