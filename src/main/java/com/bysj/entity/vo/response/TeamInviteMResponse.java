package com.bysj.entity.vo.response;

import com.bysj.common.request.BaseEntity;

import java.util.Date;


/**
 * <p>
 * TeamInviteResponse 响应对象
 * </p>
 *
 * @author wh
 * @since 2018-12-27
 */

public class TeamInviteMResponse extends BaseEntity {

    private String teamName;
    private String plateName;
    private Integer teamCount;
    private Date gmtCreate;
    private String gmtCreateStr;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public Integer getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(Integer teamCount) {
        this.teamCount = teamCount;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }
}