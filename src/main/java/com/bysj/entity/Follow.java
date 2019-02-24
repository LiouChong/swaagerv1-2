package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 关注人列表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class Follow extends BaseEntity {


    private static final long serialVersionUID = 1L;

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


    @Override
    public String toString() {
        return "Follow{" +
                "fanId=" + fanId +
                ", starId=" + starId +
                ", time=" + time +
                ", ifDelete=" + ifDelete +
                "}";
    }
}