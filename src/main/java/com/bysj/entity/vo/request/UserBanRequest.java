package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * UserBanRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class UserBanRequest   {

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

}