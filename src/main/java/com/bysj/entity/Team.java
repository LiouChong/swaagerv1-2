package com.bysj.entity;


import com.bysj.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 讨论组表
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */

public class Team extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String teamName;
    @ApiModelProperty("")
    private Integer memberCount;
    @ApiModelProperty("")
    private Integer plateId;
    @ApiModelProperty("")
    private String plateName;
    @ApiModelProperty("")
    private String leaderId;
    @ApiModelProperty("")
    private String leaderName;
    @ApiModelProperty("")
    private Boolean ifDelete;


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }


    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }


    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }


    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }


    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }


    public Boolean getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
    }


    @Override
    public String toString() {
        return "Team{" +
                ", teamName=" + teamName +
                ", memberCount=" + memberCount +
                ", plateId=" + plateId +
                ", plateName=" + plateName +
                ", leaderId=" + leaderId +
                ", leaderName=" + leaderName +
                ", ifDelete=" + ifDelete +
                "}";
    }
}