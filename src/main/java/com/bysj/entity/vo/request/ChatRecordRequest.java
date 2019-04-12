package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * ChatRecordRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class ChatRecordRequest  {

    /**
     *  聊天内容
     */
    @ApiModelProperty("聊天内容")
    private String content;
    /**
     *  讨论组小组id
     */
    @ApiModelProperty("讨论组小组id")
    private Integer teamId;
    /**
     *  创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     *  创建者id
     */
    @ApiModelProperty("创建者id")
    private Integer userCreate;

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

    public Integer getUserCreate() {
    return userCreate;
    }

    public void setUserCreate(Integer userCreate) {
        this.userCreate = userCreate;
        }

}