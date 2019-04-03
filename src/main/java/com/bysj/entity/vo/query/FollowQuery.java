package com.bysj.entity.vo.query;


import com.bysj.common.request.ObjectQuery;

/**
 * <p>
 * Follow 查询条件
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class FollowQuery {
    /**
     * 粉丝id
     */
    private Integer fanId;

    /**
     * 被关注着id
     */
    private Integer starId;

    /**
     * 查询的类型，1 查询粉丝,2 查询关注的人
     */
    private Integer type;
    private int pageSize = 5;
    private int currentPage = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFanId() {
        return fanId;
    }

    public void setFanId(Integer fanId) {
        this.fanId = fanId;
    }

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public int getPageOffset() {
        return (this.currentPage - 1) * this.pageSize;
    }
}