package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Post;
import com.cuit.bbs.dao.PostDao;
import com.cuit.bbs.service.IPostService;
import com.cuit.bbs.entity.dto.Post;
import com.cuit.bbs.entity.vo.request.PostRequest;
import com.cuit.bbs.entity.vo.response.PostResponse;
import com.cuit.bbs.entity.vo.query.PostQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 讨论帖子表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class PostServiceImpl extends BaseServiceImpl<Post> implements IPostService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private PostDao postDao;
        @Resource
        private BaseConverter<PostRequest, Post>  requestConverter;
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
            List<PostResponse> postResponse = responseConverter.convert(postList,PostResponse.class );
            return postResponse;
        }

        @Override
        public PageResult<PostResponse> findPagePost(PostQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListPost(query));
        }
}
