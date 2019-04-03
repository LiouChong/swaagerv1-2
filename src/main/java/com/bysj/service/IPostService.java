package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.PageResult;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.ManagePostQuery;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.request.PostDel;
import com.bysj.entity.vo.request.PostRequest;
import com.bysj.entity.vo.response.PlateNameForIndex;
import com.bysj.entity.vo.response.PostBanResponse;
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
         * 根据传入条件批量查询，用于推荐帖子
         * @param query
         * @return
         */
        List<PostResponse> findPagePost(PostQueryForList query, String pageName) throws Exception;

        /**
         * 查询帖子的数量，用于推荐页面，个人信息页面
         * @param query
         * @return
         * @throws Exception
         */
        Integer findPagePostCount(PostQueryForList query) throws Exception;

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
        PostDetailResponse getPostDetailById(Integer id) throws Exception;

        /**
         * 查询所有板块名称
         * @return
         */
        List<PlateNameForIndex> findAllPlateNames();

        /**
         * 查询所有帖子
         * @return
         */
        List<PostResponse> findAllPostTimeDesc(ObjectQuery objectQuery);

        /**
         * 查询所有帖子数量
         * @return
         */
        Integer findAllPostCount();

        /**
         *分页查询所有被封禁的帖子
         * @return
         */
        PageResult<PostBanResponse> findManagePagePost(ManagePostQuery managePostQuery);

        /**
         * 取消推荐帖子
         * @param
         * @return
         */
        String calcenGoodPost(Post post) throws Exception;

        /**
         * 设置推荐帖子
         * @param post
         * @return
         */
        Integer setGoodPost(Post post);

        /**
         * 根据id删除帖子
         * @param postDel
         * @return
         */
        Integer delById(PostDel postDel);


        /**
         * 根据逐查询post所有字段。
         * @param id
         * @return
         */
        Post getAllById(Integer id);
}
