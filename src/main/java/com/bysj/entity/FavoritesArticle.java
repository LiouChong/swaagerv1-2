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
 * @since 2019-01-10
 */

public class FavoritesArticle extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer userId;
    @ApiModelProperty("")
    private Integer postId;
    @ApiModelProperty("")
    private Date time;
    @ApiModelProperty("")
    private Boolean ifDelete;


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


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public Boolean getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
    }


    @Override
    public String toString() {
        return "FavoritesArticle{" +
                "userId=" + userId +
                ", postId=" + postId +
                ", time=" + time +
                ", ifDelete=" + ifDelete +
                "}";
    }
}