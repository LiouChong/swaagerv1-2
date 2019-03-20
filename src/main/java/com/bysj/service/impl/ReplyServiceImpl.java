package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.ReplyDao;
import com.bysj.entity.Post;
import com.bysj.entity.Reply;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.ReplyQuery;
import com.bysj.entity.vo.request.ReplyDelRequest;
import com.bysj.entity.vo.request.ReplyRequest;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.entity.vo.response.ReplyForPostDetail;
import com.bysj.entity.vo.response.ReplyResponse;
import com.bysj.service.IPostService;
import com.bysj.service.IReplyService;
import org.apache.shiro.SecurityUtils;
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
    private BaseConverter<ReplyDelRequest, Reply> requestDelConverter;
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
    /**
     * 三种情况下可以删回复：
     * 1.管理权限在2或者3  (permission>2)
     * 2.回复者本人  (reply.user_id == user.id)
     * 3.帖子的拥有着 (post.poster_id == user.id)
     *
     * @param request
     * @return
     */
    @Override
    public String updateReply(ReplyDelRequest request) throws Exception {
        Date nowDate = new Date();
        User user = userHandle.getUser();
        if (user == null) {
            return "您没有权限！";
        }
        Reply reply = replyDao.getById(request.getId());
        // 删除回复之前对帖子信息进行修改
        Post post = postService.getAllById(request.getPostId());
        // 执行删除之前先根据帖子拥有着和权限和回复拥有着进行判断。
        if (user.getLevel() > 1 || user.getId().equals(post.getPosterId()) || user.getId().equals(reply.getUserCreate())) {
            post.setGmtModify(nowDate);
            post.setModifyUser(user.getId());
            // 设置回复数减一
            post.setReplyCount(post.getReplyCount() - 1);
            postService.update(post);

            request.setGmtModify(nowDate);
            request.setUserModify(user.getId());
            Reply replyInfo = requestDelConverter.convert(request, Reply.class);

            replyDao.update(replyInfo);
            return "成功!";
        } else {
            return "您没有权限删除！";
        }

    }

    @Override
    public List<ReplyResponse> findListReply(ReplyQuery query) throws Exception {
        List<Reply> replyList = replyDao.findQuery(query);
        //TODO
        List<ReplyResponse> replyResponse = responseConverter.convert(replyList, ReplyResponse.class);
        return replyResponse;
    }

    @Override
    public PageResult<ReplyForPostDetail> findPageReply(ReplyQuery query) throws Exception {
        // 查询得到帖子的回复信息
        List<ReplyForPostDetail> replys = replyDao.findReplyForPost(query);

        // 对回复信息的日期进行转换
        replys.forEach(item -> {
            item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
        });

        Integer count = replyDao.findCountForDetail(query);
        return new PageResult<>(query.getPageSize(), count, query.getCurrentPage(), replys);
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
