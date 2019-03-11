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
 * @since 2019-02-28
 */

public class Reply extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 回复信息
     */
    @ApiModelProperty("回复信息")
    private String replyInfo;
    /**
     * 帖子id
     */
    @ApiModelProperty("帖子id")
    private Integer postId;
    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer thumbupCount;
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
     * 修改者id
     */
    @ApiModelProperty("修改者id")
    private Integer userModify;

    /**
     * 状态
     * @return
     */
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
    }


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }


    public Integer getThumbupCount() {
        return thumbupCount;
    }

    public void setThumbupCount(Integer thumbupCount) {
        this.thumbupCount = thumbupCount;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"replyInfo\":\"")
                .append(replyInfo).append('\"');
        sb.append(",\"postId\":")
                .append(postId);
        sb.append(",\"thumbupCount\":")
                .append(thumbupCount);
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"userCreate\":")
                .append(userCreate);
        sb.append(",\"userModify\":")
                .append(userModify);
        sb.append(",\"state\":")
                .append(state);
        sb.append('}');
        return sb.toString();
    }
}