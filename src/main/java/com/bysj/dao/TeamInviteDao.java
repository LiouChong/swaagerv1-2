package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.TeamInvite;
import com.bysj.entity.vo.response.TeamInviteMResponse;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-04-07
 */
public interface TeamInviteDao extends IBaseDao<TeamInvite> {
    /**
     * 获得我的讨论组邀请
     * @param userId
     * @return
     */
    List<TeamInviteMResponse> getMy(Integer userId);
}
