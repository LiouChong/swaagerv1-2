package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.UserTeamRel;
import com.bysj.entity.vo.response.UserTeamDetailResponse;

import java.util.List;

/**
 * <p>
 * 用户小组关联表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface UserTeamRelDao extends IBaseDao<UserTeamRel> {
    /**
     * 查询用户加入的组的数量
     * @param userId
     * @return
     */
    Integer selectUserTeamCount(Integer userId);

    List<UserTeamDetailResponse> selectUsersFromTeamId(Integer teamId);
}
