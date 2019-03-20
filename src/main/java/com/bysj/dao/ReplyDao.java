package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Reply;
import com.bysj.entity.vo.query.ReplyQuery;
import com.bysj.entity.vo.response.ReplyForPostDetail;

import java.util.List;

/**
 * <p>
 * 回复表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface ReplyDao extends IBaseDao<Reply> {
    List<ReplyForPostDetail> findReplyForPost(ReplyQuery replyQuery);
    Integer findCountForDetail(ReplyQuery replyQuery);
}
