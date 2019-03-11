package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.ReplyDao;
import com.bysj.entity.Post;
import com.bysj.entity.Reply;
import com.bysj.entity.vo.query.ReplyQuery;
import com.bysj.entity.vo.request.ReplyRequest;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.entity.vo.response.ReplyResponse;
import com.bysj.service.IPostService;
import com.bysj.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
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
    @Autowired
    private UserHandle userHandle;

    @Autowired
    private IPostService postService;

    @Override
    public PostDetailResponse saveReply(ReplyRequest request) throws Exception {
        Reply reply = requestConverter.convert(request, Reply.class);

        Date nowDate = new Date();

        Integer userId = userHandle.getUserId();

        // 给回复的修改时间、创建时间、创建人、修改人赋值
        reply.setGmtCreate(nowDate);
        reply.setGmtModify(nowDate);
        reply.setUserCreate(userId);
        reply.setUserModify(userId);

        // 修改帖子的修改时间、修改人id
        Post post = postService.getById(reply.getPostId());
        post.setId(reply.getPostId());
        post.setGmtModify(nowDate);
        post.setModifyUser(userId);
        //设置回复数+1
        post.setReplyCount(post.getReplyCount() + 1);

        // 执行
        postService.update(post);
        replyDao.insert(reply);

        return postService.getPostDetailById(reply.getPostId());
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

    @Override
    public Integer deleteById(Serializable id) throws Exception {
        Reply reply = this.getById(id);
        reply.setState(0);
        reply.setUserModify(userHandle.getUserId());
        reply.setGmtModify(new Date());

        return reply.getPostId();
    }
}
