package com.bysj.entity.vo.query;


import com.bysj.common.request.ObjectQuery;

/**
 * <p>
 * User 查询条件
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class UserQueryByLevel extends ObjectQuery {
    /**
     * 用户权限
     */
    private Integer userLevel;

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
}