package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 用户小组关联表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class UserTeamRel extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 讨论组id
     */
    @ApiModelProperty("讨论组id")
    private Integer teamId;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":")
                .append(userId);
        sb.append(",\"teamId\":")
                .append(teamId);
        sb.append(",\"state\":")
                .append(state);
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append('}');
        return sb.toString();
    }
}