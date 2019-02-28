package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.PostDTO;
import com.cuit.bbs.entity.vo.query.PostQuery;
import com.cuit.bbs.entity.vo.request.PostRequest;
import com.cuit.bbs.entity.vo.response.PostResponse;
import com.cuit.bbs.entity.Post;


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
        List<PostResponse> findListPost(PostQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<PostResponse> findPagePost(PostQuery query) throws Exception;

}
