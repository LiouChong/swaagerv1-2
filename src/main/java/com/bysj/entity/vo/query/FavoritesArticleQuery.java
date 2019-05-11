package com.bysj.entity.vo.query;


import com.bysj.common.request.ObjectQuery;

/**
 * <p>
 * FavoritesArticle 查询条件
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class FavoritesArticleQuery extends ObjectQuery {
    /**
     * 综合查询
     */
    private String integratedQuery;


    /**
     * 用户id
     */
    private Integer userId;

    public String getIntegratedQuery() {
        return integratedQuery;
    }

    public void setIntegratedQuery(String integratedQuery) {
        this.integratedQuery = integratedQuery;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}