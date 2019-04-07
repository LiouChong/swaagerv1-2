package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author lc
 * @since 2019-04-07
 */

public class TeamInvite extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 小组id
     */
    @ApiModelProperty("小组id")
    private Integer teamId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;
    /**
     * 创建人id
     */
    @ApiModelProperty("创建人id")
    private Integer userCreate;
    /**
     * 修改人id
     */
    @ApiModelProperty("修改人id")
    private Integer userModify;
    /**
     * 状态：1 有效，0 无效
     */
    @ApiModelProperty("状态：1 有效，0 无效")
    private Integer state;


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }


    public Integer getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Integer userCreate) {
        this.userCreate = userCreate;
    }


    public Integer getUserModify() {
        return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "TeamInvite{" +
                ", teamId=" + teamId +
                ", userId=" + userId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", userCreate=" + userCreate +
                ", userModify=" + userModify +
                ", state=" + state +
                "}";
    }
}