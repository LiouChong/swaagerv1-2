package com.bysj.entity.vo.request;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * TeamInviteRequest 请求对象
 * </p>
 *
 * @author liuchong
 * @since 2018-12-27
 */

public class TeamInviteUpdateRequest extends BaseEntity{

    /**
     *  小组id
     */
    @ApiModelProperty("小组id")
    private Integer teamId;

                
    public Integer getTeamId() {
    return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
        }

}