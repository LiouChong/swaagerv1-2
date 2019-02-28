package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Reply;
import com.cuit.bbs.dao.ReplyDao;
import com.cuit.bbs.service.IReplyService;
import com.cuit.bbs.entity.dto.Reply;
import com.cuit.bbs.entity.vo.request.ReplyRequest;
import com.cuit.bbs.entity.vo.response.ReplyResponse;
import com.cuit.bbs.entity.vo.query.ReplyQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 回复表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements IReplyService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private ReplyDao replyDao;
        @Resource
        private BaseConverter<ReplyRequest, Reply>  requestConverter;
        @Resource
        private BaseConverter<Reply, ReplyResponse> responseConverter;

        @Override
        public Integer saveReply(ReplyRequest request) throws Exception {
            Reply reply = requestConverter.convert(request, Reply.class);
            return replyDao.insert(reply);
        }

        @Override
        public Integer updateReply(ReplyRequest request) throws Exception {
            Reply reply = requestConverter.convert(request, Reply.class);
            return replyDao.update(reply);
        }

        @Override
        public List<ReplyResponse> findListReply(ReplyQuery query) throws Exception {
            List<Reply> replyList = replyDao.findQuery(query);
            //TODO
            List<ReplyResponse> replyResponse = responseConverter.convert(replyList,ReplyResponse.class );
            return replyResponse;
        }

        @Override
        public PageResult<ReplyResponse> findPageReply(ReplyQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListReply(query));
        }
}
