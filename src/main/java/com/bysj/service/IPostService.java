package com.bysj.service;


import com.bysj.common.IBaseService;
import com.bysj.common.PageResult;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostQuery;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.PostResponse;

import java.util.List;


/**
 * <p>
 * 讨论帖子表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
public interface IPostService extends IBaseService<Post> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer savePost(PostRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updatePost(PostRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<PostResponse> findListPost(PostQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<PostResponse> findPagePost(PostQuery query) throws Exception;

}
