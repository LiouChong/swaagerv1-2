package com.bysj.entity.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户信息页面，判断是否当前用户已关注点开的这个用户
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class BooleanFollowRequest {

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