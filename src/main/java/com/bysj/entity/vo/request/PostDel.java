package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 描述：
 **/
public class PostDel {

    private Integer id;

    private String banReason;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    private Integer modifyUser;

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getModifyUser() {
        return modifyUser;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public void setModifyUser(Integer modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"banReason\":\"")
                .append(banReason).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"modifyUser\":")
                .append(modifyUser);
        sb.append('}');
        return sb.toString();
    }
}
