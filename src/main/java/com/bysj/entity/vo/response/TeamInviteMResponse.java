package com.bysj.entity.vo.response;

import com.bysj.common.request.BaseEntity;

import java.util.Date;


/**
 * <p>
 * TeamInviteResponse 响应对象
 * </p>
 *
 * @author liuchong
 * @since 2018-12-27
 */

public class TeamInviteMResponse extends BaseEntity {

    /**
     * 小组id
     */
    private Integer teamId;
    /**
     * 组名
     */
    private String teamName;
    /**
     * 板块名
     */
    private String plateName;
    /**
     * 成员数量
     */
    private Integer teamCount;
    /**
     * 创建日期
     */
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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}