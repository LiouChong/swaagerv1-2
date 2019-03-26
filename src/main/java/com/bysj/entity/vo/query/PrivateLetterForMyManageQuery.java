package com.bysj.entity.vo.query;


import com.bysj.common.request.ObjectQuery;

/**
 * <p>
 * PrivateLetter 查询条件
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class PrivateLetterForMyManageQuery extends ObjectQuery {
    /**
     * 查询我接收的是哪些，若删除我接收的，则改变revSend = 0，查询添加条件，rev为我，并且revSend != 0。
     */
    private Integer userSendRev;
    /**
     * 查询我发送的是哪些，若我删除已发送的，则改变sendsend = 0,则通过sendsend查询会查不出来。
     */
    private Integer userSendSend;

    public Integer getUserSendRev() {
        return userSendRev;
    }

    public void setUserSendRev(Integer userSendRev) {
        this.userSendRev = userSendRev;
    }

    public Integer getUserSendSend() {
        return userSendSend;
    }

    public void setUserSendSend(Integer userSendSend) {
        this.userSendSend = userSendSend;
    }
}