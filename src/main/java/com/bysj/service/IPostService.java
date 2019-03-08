package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.PostDetailResponse;
import com.bysj.entity.vo.response.PostResponse;

import java.util.List;


/**
 * <p>
 * 讨论帖子表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IPostService extends IBaseService<Post> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer savePost(PostRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updatePost(PostRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<PostResponse> findListPost(PostQueryForList query) throws Exception;

        /**
         * 批量查询，用于推荐帖子
         * @param query
         * @return
         */
        List<PostResponse> findPagePost(PostQueryForList query) throws Exception;

        /**
         * 通过标题和内容简单查询
         * @param queryList
         * @return
         */
        List<PostResponse> findPageSimplePost(PostSimpleQueryList queryList);

        /**
         * 获取简单查询数量
         * @param queryList
         * @return
         */
        Integer findSimpleQueryCount(PostSimpleQueryList queryList);

        /**
         * 获取帖子详情。
         * @param id
         * @return
         */
        PostDetailResponse getPostDetailById(Integer id);
}
