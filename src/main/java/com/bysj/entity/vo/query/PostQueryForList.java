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
     * 帖子标题
     */
    @ApiModelProperty("帖子标题")
    private String title;
    /**
     * 帖子内容
     */
    @ApiModelProperty("帖子内容")
    private String info;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"info\":\"")
                .append(info).append('\"');
        sb.append(",\"ifGood\":")
                .append(ifGood);
        sb.append(",\"plateId\":")
                .append(plateId);
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"articleFrom\":")
                .append(articleFrom);
        sb.append(",\"articleType\":")
                .append(articleType);
        sb.append(",\"userId\":")
                .append(userId);
        sb.append('}');
        return sb.toString();
    }
}
