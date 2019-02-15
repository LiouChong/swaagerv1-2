package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * PlaterRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class PlaterRequest   {

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


}