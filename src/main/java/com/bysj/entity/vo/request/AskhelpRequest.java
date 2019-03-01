package com.bysj.entity.vo.request;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 求问表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class AskhelpRequest extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 帖子id
     */
    @ApiModelProperty("帖子id")
    private Integer postId;
    /**
     * 被求问用户id
     */
    @ApiModelProperty("被求问用户id")
    private Integer revQuestionUserId;
    /**
     * 发问用户id
     */
    @ApiModelProperty("发问用户id")
    private Integer sendQuestionUserId;
    /**
     * 求问信息
     */
    @ApiModelProperty("求问信息")
    private String message;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 状态：1 有效 2无效
     */
    @ApiModelProperty("状态：1 有效 2无效")
    private Integer state;


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }


    public Integer getRevQuestionUserId() {
        return revQuestionUserId;
    }

    public void setRevQuestionUserId(Integer revQuestionUserId) {
        this.revQuestionUserId = revQuestionUserId;
    }


    public Integer getSendQuestionUserId() {
        return sendQuestionUserId;
    }

    public void setSendQuestionUserId(Integer sendQuestionUserId) {
        this.sendQuestionUserId = sendQuestionUserId;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Askhelp{" +
                ", postId=" + postId +
                ", revQuestionUserId=" + revQuestionUserId +
                ", sendQuestionUserId=" + sendQuestionUserId +
                ", message=" + message +
                ", gmtCreate=" + gmtCreate +
                ", state=" + state +
                "}";
    }
}