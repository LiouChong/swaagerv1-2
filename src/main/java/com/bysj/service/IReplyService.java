package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.ReplyDTO;
import com.cuit.bbs.entity.vo.query.ReplyQuery;
import com.cuit.bbs.entity.vo.request.ReplyRequest;
import com.cuit.bbs.entity.vo.response.ReplyResponse;
import com.cuit.bbs.entity.Reply;


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
        Integer saveReply(ReplyRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateReply(ReplyRequest request) throws Exception;

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
        PageResult<ReplyResponse> findPageReply(ReplyQuery query) throws Exception;

}
