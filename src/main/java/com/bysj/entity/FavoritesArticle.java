package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 喜欢的文章表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class FavoritesArticle extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 帖子id
     */
    @ApiModelProperty("帖子id")
    private Integer postId;
    /**
     * 状态： 1 有效 2 无效
     */
    @ApiModelProperty("状态： 1 有效 2 无效")
    private Boolean state;
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


    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
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
        return "FavoritesArticle{" +
                "userId=" + userId +
                ", postId=" + postId +
                ", state=" + state +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", userCreate=" + userCreate +
                ", userModify=" + userModify +
                "}";
    }
}