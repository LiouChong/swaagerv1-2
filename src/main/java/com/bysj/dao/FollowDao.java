package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Follow;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

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
     * @param id
     * @return
     */
    Integer cancelFollow(Follow follow);

    Follow queryByIds(Follow follow);
}
