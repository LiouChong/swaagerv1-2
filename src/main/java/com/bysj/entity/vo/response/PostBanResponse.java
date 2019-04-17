package com.bysj.entity.vo.response;


import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * PostResponse 响应对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PostBanResponse extends BaseEntity {
    /**
     * 帖子标题
     */
    @ApiModelProperty("帖子标题")
    private String title;
    /**
     * 作者名称
     */
    private String posterName;

    /**
     * 板块名称
     */
    private String plateName;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String postGmtCreate;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private String gmtModify;

    /**
     * 删除理由
     */
    private String banReason;

    /**
     * 删除人名称
     */
    private String banUserName;

    /**
     * 帖子阅读量
     */
    private Integer readCount;

    private Integer state;

    public String getPostGmtCreate() {
        return postGmtCreate.substring(0, postGmtCreate.lastIndexOf("."));
    }

    public void setPostGmtCreate(String postGmtCreate) {
        this.postGmtCreate = postGmtCreate;
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public String getBanUserName() {
        return banUserName;
    }

    public void setBanUserName(String banUserName) {
        this.banUserName = banUserName;
    }

    public String getGmtModify() {
        return postGmtCreate.substring(0, postGmtCreate.lastIndexOf("."));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }


    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"posterName\":\"")
                .append(posterName).append('\"');
        sb.append(",\"plateName\":\"")
                .append(plateName).append('\"');
        sb.append(",\"postGmtCreate\":\"")
                .append(postGmtCreate).append('\"');
        sb.append(",\"gmtModify\":\"")
                .append(gmtModify).append('\"');
        sb.append(",\"banReason\":\"")
                .append(banReason).append('\"');
        sb.append(",\"banUserName\":\"")
                .append(banUserName).append('\"');
        sb.append(",\"readCount\":")
                .append(readCount);
        sb.append('}');
        return sb.toString();
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

}