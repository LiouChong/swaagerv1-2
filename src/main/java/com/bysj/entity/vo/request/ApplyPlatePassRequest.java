package com.bysj.entity.vo.request;

import com.bysj.common.request.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * ApplyPlateRequest 请求对象
 * </p>
 *
 * @author Liuchong
 * @since 2018-12-27
 */

public class ApplyPlatePassRequest extends BaseEntity{

    /**
     *  申请的用户id
     */
    @ApiModelProperty("申请的用户id")
    private Integer userId;
    /**
     *  申请的板块
     */
    @ApiModelProperty("申请的板块")
    private String plateName;

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public Integer getUserId() {
    return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}