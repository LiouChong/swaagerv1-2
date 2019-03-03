package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 板块表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class Plater extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 板块名称
     */
    @ApiModelProperty("板块名称")
    private String plateName;
    /**
     * 版主id
     */
    @ApiModelProperty("版主id")
    private Integer ownerId;
    /**
     * 状态:1 有效,2 无效
     */
    @ApiModelProperty("状态:1 有效,2 无效")
    private Integer state;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;
    /**
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private Integer userCreate;
    /**
     * 修改着id
     */
    @ApiModelProperty("修改着id")
    private Integer userModify;


    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }


    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Integer userCreate) {
        this.userCreate = userCreate;
    }


    public Integer getUserModify() {
        return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
    }


    @Override
    public String toString() {
        return "Plater{" +
                ", plateName=" + plateName +
                ", ownerId=" + ownerId +
                ", state=" + state +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", userCreate=" + userCreate +
                ", userModify=" + userModify +
                "}";
    }
}