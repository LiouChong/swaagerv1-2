package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * PlaterRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PlaterRequest  {

    /**
     *  板块名称
     */
    @ApiModelProperty("板块名称")
    private String plateName;
    /**
     *  版主id
     */
    @ApiModelProperty("版主id")
    private Integer ownerId;
    /**
     *  状态:1 有效,2 无效
     */
    @ApiModelProperty("状态:1 有效,2 无效")
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
    /**
     *  创建者id
     */
    @ApiModelProperty("创建者id")
    private Integer userCreate;
    /**
     *  修改着id
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




}