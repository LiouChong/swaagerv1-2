package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

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