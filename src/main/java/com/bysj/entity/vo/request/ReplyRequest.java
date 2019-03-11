package com.bysj.entity.vo.request;

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

public class ReplyRequest {

    /**
     *  回复信息
     */
    @ApiModelProperty("回复信息")
    private String replyInfo;
    /**
     *  帖子id
     */
    @ApiModelProperty("帖子id")
    private Integer postId;


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


}