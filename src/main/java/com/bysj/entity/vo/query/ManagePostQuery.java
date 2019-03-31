package com.bysj.entity.vo.query;

import com.bysj.common.request.ObjectQuery;

/**
 * @Author: 刘冲
 * @Description:后台管理页面帖子信息的展示
 * @Date: 2019/3/31 21:33
 */
public class ManagePostQuery extends ObjectQuery{
    /**
     * 帖子作者id
     */
    private Integer ownerId;

    /**
     * 是否是被删除的帖子
     */
    private Integer ifBan;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getIfBan() {
        return ifBan;
    }

    public void setIfBan(Integer ifBan) {
        this.ifBan = ifBan;
    }
}
