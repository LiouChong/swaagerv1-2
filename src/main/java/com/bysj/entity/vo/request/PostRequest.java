package com.bysj.entity.vo.request;

import com.bysj.entity.vo.response.RandUserForHelpResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * PostRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PostRequest  {

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
     * 邀请的人
     */
    private String askHelp;

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

    public String getAskHelp() {
        return askHelp;
    }

    public void setAskHelp(String askHelp) {
        this.askHelp = askHelp;
    }

}