package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Follow;
import com.bysj.entity.vo.query.FollowQuery;
import com.bysj.entity.vo.response.FollowResponse;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 关注人表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface FollowDao extends IBaseDao<Follow> {
    /**
     * 取消关注用户
     *
     * @param id
     * @return
     */
    Integer cancelFollow(Follow follow);

    /**
     * 根据id查询
     *
     * @param follow
     * @return
     */
    Follow queryByIds(Follow follow);

    /**
     * 查询粉丝或者关注人列表
     * @param query
     * @return
     */
    List<FollowResponse> findFollowUser(FollowQuery query);

    /**
     * 查询粉丝或者关注人数量
     * @param follow
     * @return
     */
    Integer findFollowUserCount(FollowQuery follow);
}
