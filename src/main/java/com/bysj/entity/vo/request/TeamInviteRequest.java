package com.bysj.entity.vo.request;


import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * TeamInviteRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class TeamInviteRequest {

    /**
     *  小组id
     */
    @ApiModelProperty("小组id")
    private Integer teamId;
    /**
     *  用户名称
     */
    @ApiModelProperty("用户名称")
    private String nickname;

                
    public Integer getTeamId() {
    return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
        }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}