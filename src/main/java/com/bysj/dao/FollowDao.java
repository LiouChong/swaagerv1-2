package com.bysj.dao;


import com.bysj.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 关注人列表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Mapper
public interface FollowDao extends IBaseDao<Follow> {

}
