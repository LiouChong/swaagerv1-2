package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * ApplyPlateRequest 请求对象
 * </p>
 *
 * @author Liuchong
 * @since 2018-12-27
 */

public class ApplyPlateRequest {

    /**
     *  申请的用户id
     */
    @ApiModelProperty("申请的用户id")
    private Integer userId;
    /**
     *  申请的理由
     */
    @ApiModelProperty("申请的理由")
    private String info;
    /**
     *  申请的板块
     */
    @ApiModelProperty("申请的板块")
    private Integer plateId;
    /**
     *  1 有效 0无效
     */
    @ApiModelProperty("1 有效 0无效")
    private Integer state;
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



    public Integer getUserId() {
    return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        }


    public String getInfo() {
    return info;
    }

    public void setInfo(String info) {
        this.info = info;
        }


    public Integer getPlateId() {
    return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
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



}