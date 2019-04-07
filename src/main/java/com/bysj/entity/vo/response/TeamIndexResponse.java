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
}