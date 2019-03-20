package com.bysj.entity.vo.request;

import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * UserRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class UserRequestForBan extends BaseEntity {

    /**
     * 封禁原因
     */
   private String banReason;

    /**
     * 封禁时间
     */
   private Date gmtModify;

    /**
     * 执行人
     */
   private Integer modifyUser;

    /**
     * 状态
     */
   private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public Integer getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Integer modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"banReason\":\"")
                .append(banReason).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"modifyUser\":")
                .append(modifyUser);
        sb.append(",\"state\":")
                .append(state);
        sb.append('}');
        return sb.toString();
    }
}