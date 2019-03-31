package com.bysj.dao;

import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.ManagePostQuery;
import com.bysj.entity.vo.query.PostQueryForList;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.request.PostDel;
import com.bysj.entity.vo.response.*;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 讨论帖子表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface PostDao extends IBaseDao<Post> {
    /**
     * 简单查询
     * @param queryList
     * @return
     */
    List<PostResponse> findPageSimplePost(PostSimpleQueryList queryList);

    /**
     * 简单查询数量
     * @param queryList
     * @return
     */
    Integer findSimpleQueryCount(PostSimpleQueryList queryList);

    /**
     * 查询帖子详情
     * @param id
     * @return
     */
    PostDetailResponse findPostDetail(@Param("id") Integer id);

    /**
     * 查询帖子详情里面的回复列表
     * @param postId
     * @return
     */
    List<ReplyForPostDetail> findReplyForPost(@Param("postId") Integer postId);

    /**
     * 根据条件查询帖子列表
     * @param query
     * @return
     */
    List<PostResponse> findPostQuery(PostQueryForList query);

    /**
     * 查询首页推荐的帖子
     * @return
     */
    List<PostResponse> findPostForIndex();

    /**
     * 时间顺序查询所有帖子
     * @param objectQuery
     * @return
     */
    List<PostResponse> findAllPostTimeDesc(ObjectQuery objectQuery);

    /**
     * 查询所有帖子数量
     * @return
     */
    Integer findAllPostCount();

    /**
     * 查询被封禁帖子
     * @param objectQuery
     * @return
     */
    List<PostBanResponse> findPageManagePost(ManagePostQuery managePostQuery);

    /**
     * 查询被封禁帖子数量
     * @return
     */
    Integer findPagePostCount(ManagePostQuery managePostQuery);

    /**
     * 推荐帖子
     * @param post
     * @return
     */
    Integer setGoodPost(Post post);

    /**
     * 删除帖子
     * @param postDel
     * @return
     */
    Integer delPost(PostDel postDel);


    /**
     * 全量查询帖子
     * @param id
     * @return
     */
    Post getAllById(Integer id);
}
