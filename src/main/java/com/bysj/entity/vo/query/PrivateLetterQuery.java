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

public class PrivateLetterQuery extends ObjectQuery {
    /**
     * 私信的接收者
     */
    private Integer userSendRev;
    /**
     * 是否已读:1 已读,0 未读
     */
    private Integer ifRead;
    /**
     * 私信类型:1 用户私信,2 系统私信
     */
    private Integer letterType;

    public Integer getUserSendRev() {
        return userSendRev;
    }

    public void setUserSendRev(Integer userSendRev) {
        this.userSendRev = userSendRev;
    }

    public Integer getIfRead() {
        return ifRead;
    }

    public void setIfRead(Integer ifRead) {
        this.ifRead = ifRead;
    }

    public Integer getLetterType() {
        return letterType;
    }

    public void setLetterType(Integer letterType) {
        this.letterType = letterType;
    }

}