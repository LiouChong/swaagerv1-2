package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.utils.NumberChineseEx;
import com.bysj.dao.PostDao;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
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
 * @since 2019-02-28
 */
@Service
public class PostServiceImpl extends BaseServiceImpl<Post> implements IPostService {
    @Resource
    private PostDao postDao;
    @Resource
    private BaseConverter<PostRequest, Post> requestConverter;
    @Resource
    private BaseConverter<Post, PostResponse> responseConverter;
    @Resource
    private NumberChineseEx numberChineseEx;

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
    public List<PostResponse> findListPost(PostQueryForList query) throws Exception {
        List<Post> postList = postDao.findQuery(query);
        //TODO
        List<PostResponse> postResponse = responseConverter.convert(postList, PostResponse.class);
        return postResponse;
    }

    @Override
    public List<PostResponse> findPagePost(PostQueryForList query) throws Exception {
        // 根据条件查询到符合的帖子集合
        List<PostResponse> postList = this.findListPost(query);

        //对帖子集合进行数字中文转换
        for (PostResponse postResponse : postList) {
            exChangeNumber(postResponse);
        }

        return postList;
    }

    @Override
    public List<PostResponse> findPageSimplePost(PostSimpleQueryList queryList) {
        // 简单查询获取到结果
        List<PostResponse> postResponses = postDao.findPageSimplePost(queryList);

        // 对帖子集合进行数字中文转换
        for (PostResponse postRespons : postResponses) {
            exChangeNumber(postRespons);
        }

        return postResponses;
    }

    @Override
    public Integer findSimpleQueryCount(PostSimpleQueryList queryList) {
        return postDao.findSimpleQueryCount(queryList);
    }

    private void exChangeNumber(PostResponse postResponse) {
        postResponse.setIfGoodStr(numberChineseEx.NumExchangeChinese(postResponse, "ifGood"));
        postResponse.setArticleFromStr(numberChineseEx.NumExchangeChinese(postResponse, "articleFrom"));
        postResponse.setArticleTypeStr(numberChineseEx.NumExchangeChinese(postResponse, "articleType"));
    }
}
