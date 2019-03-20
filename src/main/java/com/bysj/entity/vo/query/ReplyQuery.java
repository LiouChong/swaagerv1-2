package com.bysj.entity.vo.query;


import com.bysj.common.request.ObjectQuery;

/**
 * <p>
 * Reply 查询条件
 * </p>
 *
 * @author 刘冲
 * @since 2018-12-27
 */

public class ReplyQuery extends ObjectQuery {
    private Integer postId;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"postId\":")
                .append(postId);
        sb.append('}');
        return sb.toString();
    }
}