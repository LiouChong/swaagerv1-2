package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * UserTeamRelRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class UserTeamRelRequest  {

    /**
     *  用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     *  讨论组id
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




}