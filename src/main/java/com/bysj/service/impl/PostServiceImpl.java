package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.dao.PostDao;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostQuery;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.PostResponse;
import com.bysj.service.IPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讨论帖子表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class PostServiceImpl extends BaseServiceImpl<Post> implements IPostService {


    @Resource
    private PostDao postDao;
    @Resource
    private BaseConverter<PostRequest, Post> requestConverter;
    @Resource
    private BaseConverter<Post, PostResponse> responseConverter;

    @Override
    public Integer savePost(PostRequest request) throws Exception {
        Post post = requestConverter.convert(request, Post.class);
        return postDao.insert(post);
    }

    @Override
    public Integer updatePost(PostRequest request) throws Exception {
        Post post = requestConverter.convert(request, Post.class);
        return postDao.update(post);
    }

    @Override
    public List<PostResponse> findListPost(PostQuery query) throws Exception {
        List<Post> postList = postDao.findQuery(query);
        //TODO
        List<PostResponse> postResponse = responseConverter.convert(postList, PostResponse.class);
        return postResponse;
    }

    @Override
    public PageResult<PostResponse> findPagePost(PostQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListPost(query));
    }
}
