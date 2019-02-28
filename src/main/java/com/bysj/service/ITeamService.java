package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.TeamDTO;
import com.cuit.bbs.entity.vo.query.TeamQuery;
import com.cuit.bbs.entity.vo.request.TeamRequest;
import com.cuit.bbs.entity.vo.response.TeamResponse;
import com.cuit.bbs.entity.Team;


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

}
