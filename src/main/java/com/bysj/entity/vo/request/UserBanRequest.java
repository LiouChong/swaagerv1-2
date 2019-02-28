package com.bysj.entity.vo.request;

import com.antiy.common.base.BasicRequest;
import io.swagger.annotations.ApiModelProperty;
import com.antiy.common.validation.ObjectValidator;
import com.antiy.common.exception.RequestParamValidateException;
/**
 * <p>
 * UserBanRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class UserBanRequest extends BasicRequest implements ObjectValidator{

    /**
     *  被封禁用户id
     */
    @ApiModelProperty("被封禁用户id")
    private Integer banUserId;
    /**
     *  操作人id
     */
    @ApiModelProperty("操作人id")
    private Integer handUserId;
    /**
     *  结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endTime;
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
     *  修改者id
     */
    @ApiModelProperty("修改者id")
    private Integer userModify;



    public Integer getBanUserId() {
    return banUserId;
    }

    public void setBanUserId(Integer banUserId) {
        this.banUserId = banUserId;
        }


    public Integer getHandUserId() {
    return handUserId;
    }

    public void setHandUserId(Integer handUserId) {
        this.handUserId = handUserId;
        }


    public Date getEndTime() {
    return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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


    public Integer getUserModify() {
    return userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
        }


    @Override
    public void validate() throws RequestParamValidateException {

    }

}