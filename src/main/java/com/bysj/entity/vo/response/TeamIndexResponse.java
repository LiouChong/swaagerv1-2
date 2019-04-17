package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;

/**
 * <p>
 * TeamResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class TeamIndexResponse extends BaseEntity {
    /**
     * 组名
     */
    private String teamName;
    /**
     * 人数
     */
    private String count;
    /**
     * 板块名字
     */
    private String plateName;

    /**
     * 加入时间
     * @return
     */
    private String gmtCreate;

    /**
     * 说明
     * @return
     */
    private String memo;

    /**
     * 组长id
     */
    private Integer leaderId;

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getGmtCreate() {
        return gmtCreate.substring(0, gmtCreate.lastIndexOf("."));
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }
}