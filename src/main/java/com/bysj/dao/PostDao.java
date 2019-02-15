package com.bysj.dao;


import com.bysj.entity.Post;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 讨论帖子表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Mapper
public interface PostDao extends IBaseDao<Post> {

}
