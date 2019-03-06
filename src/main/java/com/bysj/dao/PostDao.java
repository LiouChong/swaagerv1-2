package com.bysj.dao;

import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Post;
import com.bysj.entity.vo.query.PostSimpleQueryList;
import com.bysj.entity.vo.response.PostResponse;

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


    Integer findSimpleQueryCount(PostSimpleQueryList queryList);
}
