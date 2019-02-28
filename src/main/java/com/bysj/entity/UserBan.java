package com.bysj.entity;


import java.util.Date;
import com.antiy.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 用户封禁表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class UserBan extends BaseEntity {


private static final long serialVersionUID = 1L;

        /**
    *  被封禁用户id
    */
        @ApiModelProperty("被封禁用户id")
    private Integer banUserId;
        /**
    *  操作人id
    */
        @ApiModelProperty("操作人id")
    private Integer handUserId;
        /**
    *  结束时间
    */
        @ApiModelProperty("结束时间")
    private Date endTime;
        /**
    *  创建时间
    */
        @ApiModelProperty("创建时间")
    private Date gmtCreate;
        /**
    *  修改时间
    */
        @ApiModelProperty("修改时间")
    private Date gmtModify;
        /**
    *  修改者id
    */
        @ApiModelProperty("修改者id")
    private Integer userModify;



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


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }


    public Integer getUserModify() {
        return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
    }


        @Override
    public String toString() {
            return "UserBan{" +
                                                                                            ", banUserId=" + banUserId +
                                                                                        ", handUserId=" + handUserId +
                                                                                        ", endTime=" + endTime +
                                                                                        ", gmtCreate=" + gmtCreate +
                                                                                        ", gmtModify=" + gmtModify +
                                                                                        ", userModify=" + userModify +
                                                "}";
    }
    }