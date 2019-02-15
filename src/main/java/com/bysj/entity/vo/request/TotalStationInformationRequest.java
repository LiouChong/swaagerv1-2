package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * TotalStationInformationRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class TotalStationInformationRequest   {

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


}