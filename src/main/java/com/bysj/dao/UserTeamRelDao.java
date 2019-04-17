package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.UserTeamRel;
import com.bysj.entity.vo.request.UserTeamRelExitRequest;
import com.bysj.entity.vo.response.UserTeamDetailResponse;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据小组id查询成员
     * @param teamId
     * @return
     */
    List<UserTeamDetailResponse> selectUsersFromTeamId(Integer teamId);

    /**
     * 删除小组内所有成员（解散小组）
     * @param teamId
     */
    Integer clearUser(Integer teamId);

    /**
     * 某个非组长用户退出小组
     * @param request
     * @return
     */
    Integer exitTeam(UserTeamRelExitRequest request);

}
