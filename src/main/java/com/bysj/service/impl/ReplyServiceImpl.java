package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.dao.ReplyDao;
import com.bysj.entity.Reply;
import com.bysj.entity.vo.query.ReplyQuery;
import com.bysj.entity.vo.request.ReplyRequest;
import com.bysj.entity.vo.response.ReplyResponse;
import com.bysj.service.IReplyService;
import org.springframework.stereotype.Service;

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
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements IReplyService {


    @Resource
    private ReplyDao replyDao;
    @Resource
    private BaseConverter<ReplyRequest, Reply> requestConverter;
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
        List<ReplyResponse> replyResponse = responseConverter.convert(replyList, ReplyResponse.class);
        return replyResponse;
    }

    @Override
    public PageResult<ReplyResponse> findPageReply(ReplyQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListReply(query));
    }
}
