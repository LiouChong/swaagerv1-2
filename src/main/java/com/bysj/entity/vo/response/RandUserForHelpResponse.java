package com.bysj.entity.vo.response;

import com.bysj.common.request.BaseEntity;

/**
 * 描述：
 * @Author:Liuchong
 * @Date: 2019/3/15 14:16
 */
public class RandUserForHelpResponse{
    private Integer revQuestionUserId;
    private String nickname;
    private String picture;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getRevQuestionUserId() {
        return revQuestionUserId;
    }

    public void setRevQuestionUserId(Integer revQuestionUserId) {
        this.revQuestionUserId = revQuestionUserId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"revQuestionUserId\":")
                .append(revQuestionUserId);
        sb.append(",\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"picture\":\"")
                .append(picture).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
