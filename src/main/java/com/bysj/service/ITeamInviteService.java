package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import com.bysj.entity.TeamInvite;
import com.bysj.entity.vo.query.TeamInviteQuery;
import com.bysj.entity.vo.request.TeamInviteRequest;
import com.bysj.entity.vo.response.TeamInviteMResponse;
import com.bysj.entity.vo.response.TeamInviteResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lc
 * @since 2019-04-07
 */
public interface ITeamInviteService extends IBaseService<TeamInvite> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveTeamInvite(TeamInviteRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateTeamInvite(TeamInviteRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<TeamInviteResponse> findListTeamInvite(TeamInviteQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<TeamInviteResponse> findPageTeamInvite(TeamInviteQuery query) throws Exception;

        /**
         * 查询我获得的讨论组邀请
         * @return
         */
        List<TeamInviteMResponse> getMyTeamInvite();
}
