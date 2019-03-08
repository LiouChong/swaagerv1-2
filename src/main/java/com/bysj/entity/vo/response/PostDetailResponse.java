package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * PostResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PostDetailResponse extends BaseEntity {
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
     * 作者名称
     */
    private String posterName;

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
     * 板块名称
     */
    private Integer plateName;
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
     * 文章的类型:1讨论帖,2 资源贴,3 求问贴
     */
    @ApiModelProperty("文章的类型:1讨论帖,2 资源贴,3 求问贴")
    private Integer articleType;

    /**
     * 该帖子的回复列表
     * @return
     */

    private List<ReplyForPostDetail> replys;

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

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
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

    public Integer getPlateName() {
        return plateName;
    }

    public void setPlateName(Integer plateName) {
        this.plateName = plateName;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
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

    public List<ReplyForPostDetail> getReplys() {
        return replys;
    }

    public void setReplys(List<ReplyForPostDetail> replys) {
        this.replys = replys;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"info\":\"")
                .append(info).append('\"');
        sb.append(",\"posterId\":")
                .append(posterId);
        sb.append(",\"posterName\":\"")
                .append(posterName).append('\"');
        sb.append(",\"ifGood\":")
                .append(ifGood);
        sb.append(",\"plateId\":")
                .append(plateId);
        sb.append(",\"plateName\":")
                .append(plateName);
        sb.append(",\"replyCount\":")
                .append(replyCount);
        sb.append(",\"thumbupCount\":")
                .append(thumbupCount);
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"createUser\":")
                .append(createUser);
        sb.append(",\"modifyUser\":")
                .append(modifyUser);
        sb.append(",\"readCount\":")
                .append(readCount);
        sb.append(",\"articleFrom\":")
                .append(articleFrom);
        sb.append(",\"articleType\":")
                .append(articleType);
        sb.append(",\"replys\":")
                .append(replys);
        sb.append('}');
        return sb.toString();
    }
}