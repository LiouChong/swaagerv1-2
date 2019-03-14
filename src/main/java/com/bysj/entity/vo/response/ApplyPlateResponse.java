package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;

import java.util.Date;

/**
 * <p>
 * ApplyPlateResponse 响应对象
 * </p>
 *
 * @author Liuchong
 * @since 2018-12-27
 */

public class ApplyPlateResponse extends BaseEntity {
    /**
     * 申请人id
     */
    private Integer applyUserId;
    /**
     * 申请人
     */
    private String applyUserName;

    /**
     * 申请信息
     */

    private String applyInfo;

    /**
     * 申请版块
     */
    private String applyPlateName;

    /**
     * 申请时间
     */
    private Date applyTime;

    private String applyTimeStr;

    public String getApplyTimeStr() {
        return applyTimeStr;
    }

    public void setApplyTimeStr(String applyTimeStr) {
        this.applyTimeStr = applyTimeStr;
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getApplyInfo() {
        return applyInfo;
    }

    public void setApplyInfo(String applyInfo) {
        this.applyInfo = applyInfo;
    }

    public String getApplyPlateName() {
        return applyPlateName;
    }

    public void setApplyPlateName(String applyPlateName) {
        this.applyPlateName = applyPlateName;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"applyUserId\":")
                .append(applyUserId);
        sb.append(",\"applyUserName\":\"")
                .append(applyUserName).append('\"');
        sb.append(",\"applyInfo\":\"")
                .append(applyInfo).append('\"');
        sb.append(",\"applyPlateName\":\"")
                .append(applyPlateName).append('\"');
        sb.append(",\"applyTime\":\"")
                .append(applyTime).append('\"');
        sb.append(",\"applyTimeStr\":\"")
                .append(applyTimeStr).append('\"');
        sb.append('}');
        return sb.toString();
    }
}