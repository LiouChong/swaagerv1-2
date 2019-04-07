package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * TeamResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class TeamDetailResponse extends BaseEntity {

    /**
     * 组名
     */
    private String teamName;
    /**
     * 板块名
     */
    public String plateName;
    /**
     * 人数
     */
    private String count;
    /**
     * 说明
     */
    private String memo;
    /**
     * 创建时间
     */
    private Date gmtCreate;

    private String gmtCreateStr;
    /**
     * 成员的名字
     */
    private List<UserTeamDetailResponse> nicknames;

    /**
     * 组长id
     */
    private Integer teamLeaderId;

    /**
     * 组长名称
     */
    private String teamLeadName;

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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }

    public Date getGmtCreate() {

        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public List<UserTeamDetailResponse> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<UserTeamDetailResponse> nicknames) {
        this.nicknames = nicknames;
    }

    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public String getTeamLeadName() {
        return teamLeadName;
    }

    public void setTeamLeadName(String teamLeadName) {
        this.teamLeadName = teamLeadName;
    }
}