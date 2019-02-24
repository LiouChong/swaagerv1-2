package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 回复表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class Reply extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String replyInfo;
    @ApiModelProperty("")
    private Date replyTime;
    @ApiModelProperty("")
    private Integer userId;
    @ApiModelProperty("")
    private Integer postId;
    @ApiModelProperty("")
    private Boolean ifDelete;
    @ApiModelProperty("")
    private Integer thumbupCount;
    @ApiModelProperty("")
    private String userName;
    @ApiModelProperty("")
    private String userPicture;


    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
    }


    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }


    public Boolean getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
    }


    public Integer getThumbupCount() {
        return thumbupCount;
    }

    public void setThumbupCount(Integer thumbupCount) {
        this.thumbupCount = thumbupCount;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }


    @Override
    public String toString() {
        return "Reply{" +
                ", replyInfo=" + replyInfo +
                ", replyTime=" + replyTime +
                ", userId=" + userId +
                ", postId=" + postId +
                ", ifDelete=" + ifDelete +
                ", thumbupCount=" + thumbupCount +
                ", userName=" + userName +
                ", userPicture=" + userPicture +
                "}";
    }
}