package com.bysj.entity.vo.query;

import com.bysj.common.request.ObjectQuery;

/**
 * @Author: 刘冲
 * @Description:
 * @Date: 2019/3/3 15:33
 */
public class PostSimpleQueryList extends ObjectQuery{
    /**
     * 综合查询
     */
    private String integratedQuery;

    public String getIntegratedQuery() {
        return integratedQuery;
    }

    public void setIntegratedQuery(String integratedQuery) {
        this.integratedQuery = integratedQuery;
    }
}
