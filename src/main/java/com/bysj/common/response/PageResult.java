package com.bysj.common.response;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable, Cloneable {
    private int pageSize;
    private int totalRecords;
    private int currentPage;
    private List<T> items;
    private int totalPages;

    public PageResult() {
    }

    public PageResult(int pageSize, int totalRecord, int currentPage, List<T> items) {
        this.setPageSize(pageSize);
        this.totalRecords = totalRecord;
        this.totalPages = this.getTotalPages();
        this.setCurrentPage(currentPage);
        this.items = items;
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageSize() {
        return this.pageSize > 0 ? this.pageSize : 10;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > 0 ? pageSize : 10;
    }

    public int getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords >= 0 ? totalRecords : 0;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int page) {
        if (page != 0 && page >= 0) {
            if (page >= this.totalPages) {
                this.currentPage = this.totalPages;
            } else {
                this.currentPage = page;
            }
        } else {
            this.currentPage = 1;
        }
    }

    public int getTotalPages() {
        int total = this.totalRecords % this.pageSize;
        if (total > 0) {
            this.totalPages = this.totalRecords / this.pageSize + 1;
            return this.totalPages;
        } else {
            this.totalPages = this.totalRecords / this.pageSize;
            return this.totalPages;
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"pageSize\":")
                .append(pageSize);
        sb.append(",\"totalRecords\":")
                .append(totalRecords);
        sb.append(",\"currentPage\":")
                .append(currentPage);
        sb.append(",\"items\":")
                .append(items);
        sb.append(",\"totalPages\":")
                .append(totalPages);
        sb.append('}');
        return sb.toString();
    }
}
