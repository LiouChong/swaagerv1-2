package com.bysj.entity;


import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 版主信息表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class Plater extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer userId;
    @ApiModelProperty("")
    private Integer plateId;
    @ApiModelProperty("")
    private Date startTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    @Override
    public String toString() {
        return "Plater{" +
                ", userId=" + userId +
                ", plateId=" + plateId +
                ", startTime=" + startTime +
                "}";
    }
}