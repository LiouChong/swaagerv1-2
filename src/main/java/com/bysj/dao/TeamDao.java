package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Team;
import com.bysj.entity.vo.response.TeamDetailResponse;
import com.bysj.entity.vo.response.TeamIndexResponse;

import java.util.List;

/**
 * <p>
 * 讨论组表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface TeamDao extends IBaseDao<Team> {
    /**
     * 搜索首页小组列表
     * @param userId
     * @return
     */
    List<TeamIndexResponse> selectForPageIndex(Integer userId);

    TeamDetailResponse selectDetailBtId(Integer teamId);
}
