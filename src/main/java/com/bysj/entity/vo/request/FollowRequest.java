package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * FollowRequest 请求对象
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class FollowRequest  {

    /**
     *  被关注者id
     */
    @ApiModelProperty("被关注者id")
    private Integer starId;


    public Integer getStarId() {
    return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
        }

}