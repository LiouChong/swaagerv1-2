package com.bysj.entity.vo.response;

import com.bysj.common.request.BaseEntity;

/**
 * 描述：
 * @Author:Liuchong
 * @Date: 2019/3/15 14:16
 */
public class RandUserForHelpResponse{
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"picture\":\"")
                .append(picture).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
