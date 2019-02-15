package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * FavoritesArticleRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class FavoritesArticleRequest   {

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


}