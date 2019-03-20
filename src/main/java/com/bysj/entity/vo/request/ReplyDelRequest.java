package com.bysj.entity.vo.request;

import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * ReplyRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class ReplyDelRequest extends BaseEntity {

    /**
     * 修改者id
     */
    @ApiModelProperty("修改者id")
    private Integer userModify;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;

    /**
     * 帖子id
     */
    private Integer postId;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserModify() {
        return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userModify\":")
                .append(userModify);
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"postId\":")
                .append(postId);
        sb.append('}');
        return sb.toString();
    }
}