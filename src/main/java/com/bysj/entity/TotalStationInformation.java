package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 全站信息表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class TotalStationInformation extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String content;
    @ApiModelProperty("")
    private Date time;
    @ApiModelProperty("")
    private Integer fromUserId;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }


    @Override
    public String toString() {
        return "TotalStationInformation{" +
                ", content=" + content +
                ", time=" + time +
                ", fromUserId=" + fromUserId +
                "}";
    }
}