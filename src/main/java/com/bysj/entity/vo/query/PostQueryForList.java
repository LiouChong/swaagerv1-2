package com.bysj.entity.vo.query;

import com.bysj.common.request.ObjectQuery;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: 刘冲
 * @Description:
 * @Date: 2019/3/2 17:03
 */
public class PostQueryForList extends ObjectQuery{

    /**
     * 是否被推荐:1 被推荐,0 未被推荐
     */
    @ApiModelProperty("是否被推荐:1 被推荐,0 未被推荐")
    private Integer ifGood;
    /**
     * 板块id
     */
    @ApiModelProperty("板块id")
    private Integer plateId;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 文章的来源:1 原创,2 转载
     */
    @ApiModelProperty("文章的来源:1 原创,2 转载")
    private Integer articleFrom;
    /**
     * 文章的类型:1 讨论帖,2 资源贴,3 求问贴
     */
    @ApiModelProperty("文章的类型:1 讨论帖,2 资源贴,3 求问贴")
    private Integer articleType;

    /**
     * 用户id
     */
    private Integer userId;

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

    public Integer getIfGood() {
        return ifGood;
    }

    public void setIfGood(Integer ifGood) {
        this.ifGood = ifGood;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getArticleFrom() {
        return articleFrom;
    }

    public void setArticleFrom(Integer articleFrom) {
        this.articleFrom = articleFrom;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
