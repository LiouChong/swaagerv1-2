package com.bysj.entity.vo.request;

import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * PostRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PostUpdateRequest extends BaseEntity {

    /**
     *  帖子标题
     */
    @ApiModelProperty("帖子标题")
    private String title;
    /**
     *  帖子内容
     */
    @ApiModelProperty("帖子内容")
    private String info;
    /**
     *  作者id
     */
    @ApiModelProperty("作者id")
    private Integer posterId;
    /**
     *  板块id
     */
    @ApiModelProperty("板块id")
    private Integer plateId;
    /**
     *  文章的来源:1 原创,2 转载
     */
    @ApiModelProperty("文章的来源:1 原创,2 转载")
    private Integer articleFrom;
    /**
     *  文章的类型:1 讨论帖,2 资源贴,3 求问贴
     */
    @ApiModelProperty("文章的类型:1 讨论帖,2 资源贴,3 求问贴")
    private Integer articleType;

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

    /**
     * 是否已经解决
     */
    private Integer ifSolved;

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

    public Integer getPlateId() {
    return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
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

    public Integer getIfSolved() {
        return ifSolved;
    }

    public void setIfSolved(Integer ifSolved) {
        this.ifSolved = ifSolved;
    }
}