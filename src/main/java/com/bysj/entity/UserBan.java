package com.bysj.entity;


import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 用户封禁表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class UserBan extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer banUserId;
    @ApiModelProperty("")
    private Integer handUserId;
    @ApiModelProperty("")
    private Date endTime;


    public Integer getBanUserId() {
        return banUserId;
    }

    public void setBanUserId(Integer banUserId) {
        this.banUserId = banUserId;
    }


    public Integer getHandUserId() {
        return handUserId;
    }

    public void setHandUserId(Integer handUserId) {
        this.handUserId = handUserId;
    }


    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "UserBan{" +
                ", banUserId=" + banUserId +
                ", handUserId=" + handUserId +
                ", endTime=" + endTime +
                "}";
    }
}