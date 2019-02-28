package com.bysj.entity.vo.request;

import com.antiy.common.base.BasicRequest;
import io.swagger.annotations.ApiModelProperty;
import com.antiy.common.validation.ObjectValidator;
import com.antiy.common.exception.RequestParamValidateException;
/**
 * <p>
 * ReplyRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class ReplyRequest extends BasicRequest implements ObjectValidator{

    /**
     *  回复信息
     */
    @ApiModelProperty("回复信息")
    private String replyInfo;
    /**
     *  帖子id
     */
    @ApiModelProperty("帖子id")
    private Integer postId;
    /**
     *  点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer thumbupCount;
    /**
     *  创建时间
     */
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    /**
     *  修改时间
     */
    @ApiModelProperty("修改时间")
    private Date gmtModify;
    /**
     *  创建者id
     */
    @ApiModelProperty("创建者id")
    private String userCreate;
    /**
     *  修改者id
     */
    @ApiModelProperty("修改者id")
    private String userModify;



    public String getReplyInfo() {
    return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
        }


    public Integer getPostId() {
    return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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


    public String getUserCreate() {
    return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
        }


    public String getUserModify() {
    return userModify;
    }

    public void setUserModify(String userModify) {
        this.userModify = userModify;
        }


    @Override
    public void validate() throws RequestParamValidateException {

    }

}