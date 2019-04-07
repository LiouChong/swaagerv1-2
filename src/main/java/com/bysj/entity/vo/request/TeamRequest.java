package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * TeamRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class TeamRequest  {

    /**
     *  小组名称
     */
    @ApiModelProperty("小组名称")
    private String teamName;
    /**
     *  板块id
     */
    @ApiModelProperty("板块id")
    private Integer plateId;

    private String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTeamName() {
    return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
        }

    public Integer getPlateId() {
    return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"teamName\":\"")
                .append(teamName).append('\"');
        sb.append(",\"plateId\":")
                .append(plateId);
        sb.append(",\"memo\":\"")
                .append(memo).append('\"');
        sb.append('}');
        return sb.toString();
    }
}