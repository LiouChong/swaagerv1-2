package com.bysj.entity.vo.request;


import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * FavoritesArticleRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class FavoritesArticleRequest  {
    /**
     *  帖子id
     */
    @ApiModelProperty("帖子id")
    private Integer postId;


    public Integer getPostId() {
    return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
        }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append(",\"postId\":")
                .append(postId);
        sb.append('}');
        return sb.toString();
    }
}