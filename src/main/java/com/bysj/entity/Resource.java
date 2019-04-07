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
    private Long fileSize;
    /**
     * 资源名称
     */
    @ApiModelProperty("资源名称")
    private String fileName;
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


    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"fileUrl\":\"")
                .append(fileUrl).append('\"');
        sb.append(",\"fileSize\":")
                .append(fileSize);
        sb.append(",\"fileName\":\"")
                .append(fileName).append('\"');
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"userCreate\":")
                .append(userCreate);
        sb.append(",\"userModify\":")
                .append(userModify);
        sb.append(",\"state\":")
                .append(state);
        sb.append('}');
        return sb.toString();
    }
}