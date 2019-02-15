package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * ChatRecordRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class ChatRecordRequest   {

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

}