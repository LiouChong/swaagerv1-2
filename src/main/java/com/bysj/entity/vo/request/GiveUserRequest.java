package com.bysj.entity.vo.request;

/**
 * @Author: 刘冲
 * @Description:
 * @Date: 2019/4/22 21:46
 */
public class GiveUserRequest {
    /**
     * 要给予积分的用户id
     */
    private Integer userId;
    /**
     * 给予的积分数
     */
    private Integer money;

    /**
     * 帖子id
     */
    private Integer postId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
