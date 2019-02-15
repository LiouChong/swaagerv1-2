package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * FollowRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class FollowRequest   {

    @ApiModelProperty("")
    private Integer fanId;
    @ApiModelProperty("")
    private Integer starId;
    @ApiModelProperty("")
    private Date time;
    @ApiModelProperty("")
    private Boolean ifDelete;


    public Integer getFanId() {
    return fanId;
    }

    public void setFanId(Integer fanId) {
        this.fanId = fanId;
        }


    public Integer getStarId() {
    return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
        }


    public Date getTime() {
    return time;
    }

    public void setTime(Date time) {
        this.time = time;
        }


    public Boolean getIfDelete() {
    return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
        }



}