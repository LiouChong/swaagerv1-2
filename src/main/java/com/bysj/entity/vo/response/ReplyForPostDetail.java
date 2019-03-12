package com.bysj.entity.vo.response;

import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 描述:帖子详情中的回复。
 *
 * @author liuchong
 */
public class ReplyForPostDetail extends BaseEntity {
    /**
     * 回复信息
     */
    @ApiModelProperty("回复信息")
    private String replyInfo;

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

    private String gmtCreateStr;
    /**
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private String userCreate;

    /**
     * 创建者名字
     */
    private String userCreateName;

    /**
     * 创建者头像
     */
    private String userImg;

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }

    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
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

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserCreateName() {
        return userCreateName;
    }

    public void setUserCreateName(String userCreateName) {
        this.userCreateName = userCreateName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"replyInfo\":\"")
                .append(replyInfo).append('\"');
        sb.append(",\"thumbupCount\":")
                .append(thumbupCount);
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtCreateStr\":\"")
                .append(gmtCreateStr).append('\"');
        sb.append(",\"userCreate\":\"")
                .append(userCreate).append('\"');
        sb.append(",\"userCreateName\":\"")
                .append(userCreateName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
