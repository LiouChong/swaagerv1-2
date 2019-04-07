package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import com.bysj.entity.Team;
import com.bysj.entity.vo.query.TeamQuery;
import com.bysj.entity.vo.request.TeamRequest;
import com.bysj.entity.vo.response.TeamDetailResponse;
import com.bysj.entity.vo.response.TeamIndexResponse;
import com.bysj.entity.vo.response.TeamResponse;

import java.util.List;

/**
 * <p>
 * 讨论组表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface ITeamService extends IBaseService<Team> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveTeam(TeamRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateTeam(TeamRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<TeamResponse> findListTeam(TeamQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<TeamResponse> findPageTeam(TeamQuery query) throws Exception;

        /**
         * 根据登录用户查询讨论组信息
         * @param userId
         * @return
         */
        List<TeamIndexResponse> selectForIndex(Integer userId);

        TeamDetailResponse getDetail(Integer teamId);

}
