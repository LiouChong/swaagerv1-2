package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 讨论组聊天记录表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class ChatRecord extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 聊天内容
     */
    @ApiModelProperty("聊天内容")
    private String content;
    /**
     * 讨论组小组id
     */
    @ApiModelProperty("讨论组小组id")
    private Integer teamId;
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
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private Integer userCreate;
    /**
     * 修改着id
     */
    @ApiModelProperty("修改着id")
    private Integer userModify;
    /**
     * 状态:1 有效,0 无效
     */
    @ApiModelProperty("状态:1 有效,0 无效")
    private Integer state;


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


    public Integer getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Integer userCreate) {
        this.userCreate = userCreate;
    }


    public Integer getUserModify() {
        return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "ChatRecord{" +
                ", content=" + content +
                ", teamId=" + teamId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", userCreate=" + userCreate +
                ", userModify=" + userModify +
                ", state=" + state +
                "}";
    }
}