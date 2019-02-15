package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * UserTeamRelRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class UserTeamRelRequest   {

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


}