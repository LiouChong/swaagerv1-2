package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * ApplyplateRequest 请求对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class ApplyplateRequest {

    @ApiModelProperty("申请用户Id")
    private Integer userId;
    @ApiModelProperty("板块Id")
    private Integer plateId;
    @ApiModelProperty("申请内容")
    private String content;
    @ApiModelProperty("申请时间")
    private Date applyTime;
    @ApiModelProperty("处理时间")
    private Date handTime;



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


    public String getContent() {
    return content;
    }

    public void setContent(String content) {
        this.content = content;
        }


    public Date getApplyTime() {
    return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
        }


    public Date getHandTime() {
    return handTime;
    }

    public void setHandTime(Date handTime) {
        this.handTime = handTime;
        }


}