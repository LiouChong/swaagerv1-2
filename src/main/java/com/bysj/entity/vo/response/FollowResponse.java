package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;

import java.util.Date;

/**
 * <p>
 * FollowResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class FollowResponse extends BaseEntity {

    /**
     * 关注时间
     */
    private Date gmtCreate;

    private String gmtCreateStr;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个性签名
     */
    private String signaTure;

    /**
     * 头像
     */
    private String picture;

    /**
     * 查看关注分页所需的粉丝id
     */
    private Integer fanId;

    public Integer getFanId() {
        return fanId;
    }

    public void setFanId(Integer fanId) {
        this.fanId = fanId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignaTure() {
        return signaTure;
    }

    public void setSignaTure(String signaTure) {
        this.signaTure = signaTure;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}