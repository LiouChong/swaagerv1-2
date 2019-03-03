package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 上传的资源表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class Resource extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 资源url
     */
    @ApiModelProperty("资源url")
    private String fileUrl;
    /**
     * 资源大小
     */
    @ApiModelProperty("资源大小")
    private Integer fileSize;
    /**
     * 资源名称
     */
    @ApiModelProperty("资源名称")
    private String fileName;
    /**
     * 需要的资源数
     */
    @ApiModelProperty("需要的资源数")
    private Integer needMoney;
    /**
     * 资源的描述
     */
    @ApiModelProperty("资源的描述")
    private String desc;
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
     * 修改者id
     */
    @ApiModelProperty("修改者id")
    private Integer userModify;
    /**
     * 状态:1 有效,0 无效
     */
    @ApiModelProperty("状态:1 有效,0 无效")
    private Integer state;


    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public Integer getNeedMoney() {
        return needMoney;
    }

    public void setNeedMoney(Integer needMoney) {
        this.needMoney = needMoney;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Resource{" +
                ", fileUrl=" + fileUrl +
                ", fileSize=" + fileSize +
                ", fileName=" + fileName +
                ", needMoney=" + needMoney +
                ", desc=" + desc +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", userCreate=" + userCreate +
                ", userModify=" + userModify +
                ", state=" + state +
                "}";
    }
}