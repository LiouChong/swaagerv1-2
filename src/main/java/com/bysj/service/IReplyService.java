package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import com.bysj.entity.Reply;
import com.bysj.entity.vo.query.ReplyQuery;
import com.bysj.entity.vo.request.ReplyDelRequest;
import com.bysj.entity.vo.request.ReplyRequest;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.entity.vo.response.ReplyForPostDetail;
import com.bysj.entity.vo.response.ReplyResponse;

import java.util.List;

/**
 * <p>
 * 回复表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IReplyService extends IBaseService<Reply> {

        /**
         * 保存
         * @param request
         * @return
         */
        PostDetailResponse saveReply(ReplyRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        String updateReply(ReplyDelRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<ReplyResponse> findListReply(ReplyQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<ReplyForPostDetail> findPageReply(ReplyQuery query) throws Exception;

}
