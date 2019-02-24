package com.bysj.common.request;



import com.bysj.common.utils.DateUtils;

import java.util.Date;

public class ObjectQuery {
    private int pageSize = 10;
    private int currentPage = 1;
    private String beginTime;
    private String endTime;

    public ObjectQuery() {
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Date getBeginTime() {
        return DateUtils.getDateFormat(this.beginTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return DateUtils.getDateFormat(this.endTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPageOffset() {
        return (this.currentPage - 1) * this.pageSize;
    }
}