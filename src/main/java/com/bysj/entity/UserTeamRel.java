package com.bysj.entity;


import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户小组关联表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class UserTeamRel extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer userId;
    @ApiModelProperty("")
    private Integer teamId;


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
        return "UserTeamRel{" +
                "userId=" + userId +
                ", teamId=" + teamId +
                "}";
    }
}