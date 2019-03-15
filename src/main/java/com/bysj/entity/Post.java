package com.bysj.entity;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 讨论帖子表
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */

public class Post extends BaseEntity {


    private static final long serialVersionUID = 1L;

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
     * 作者id
     */
    @ApiModelProperty("作者id")
    private Integer posterId;
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
     * 回复数
     */
    @ApiModelProperty("回复数")
    private Integer replyCount;
    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer thumbupCount;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;
    /**
     * 创建用户
     */
    @ApiModelProperty("创建用户")
    private Integer createUser;
    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    private Integer modifyUser;
    /**
     * 状态:1 未删除,0 已删除
     */
    @ApiModelProperty("状态:1 未删除,0 已删除")
    private Integer state;
    /**
     * 阅读数
     */
    @ApiModelProperty("阅读数")
    private Integer readCount;
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
     * 被封禁理由
     */
    @ApiModelProperty("被封禁理由")
    private Integer banReason;

    /**
     * 悬赏积分
     */
    @ApiModelProperty("悬赏积分")
    private Integer giveMoney;

    /**
     * 需要积分
     */
    @ApiModelProperty("需要积分")
    private Integer needMoney;

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


    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
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


    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getBanReason() {
        return banReason;
    }

    public void setBanReason(Integer banReason) {
        this.banReason = banReason;
    }

    public Integer getGiveMoney() {
        return giveMoney;
    }

    public void setGiveMoney(Integer giveMoney) {
        this.giveMoney = giveMoney;
    }

    public Integer getNeedMoney() {
        return needMoney;
    }

    public void setNeedMoney(Integer needMoney) {
        this.needMoney = needMoney;
    }

    public Integer getThumbupCount() {
        return thumbupCount;
    }

    public void setThumbupCount(Integer thumbupCount) {
        this.thumbupCount = thumbupCount;
    }


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }


    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }


    public Integer getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Integer modifyUser) {
        this.modifyUser = modifyUser;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
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


    @Override
    public String toString() {
        return "Post{" +
                ", title=" + title +
                ", info=" + info +
                ", posterId=" + posterId +
                ", ifGood=" + ifGood +
                ", plateId=" + plateId +
                ", replyCount=" + replyCount +
                ", thumbupCount=" + thumbupCount +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", createUser=" + createUser +
                ", modifyUser=" + modifyUser +
                ", state=" + state +
                ", readCount=" + readCount +
                ", articleFrom=" + articleFrom +
                ", articleType=" + articleType +
                "}";
    }
}