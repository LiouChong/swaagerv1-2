package com.bysj.entity;


import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 用户申请版主表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class Applyplate extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer userId;
    @ApiModelProperty("")
    private Integer plateId;
    @ApiModelProperty("")
    private String content;
    @ApiModelProperty("")
    private Date applyTime;
    @ApiModelProperty("")
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


    @Override
    public String toString() {
        return "Applyplate{" +
                ", userId=" + userId +
                ", plateId=" + plateId +
                ", content=" + content +
                ", applyTime=" + applyTime +
                ", handTime=" + handTime +
                "}";
    }
}