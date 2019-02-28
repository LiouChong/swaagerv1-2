package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Team;
import com.cuit.bbs.dao.TeamDao;
import com.cuit.bbs.service.ITeamService;
import com.cuit.bbs.entity.dto.Team;
import com.cuit.bbs.entity.vo.request.TeamRequest;
import com.cuit.bbs.entity.vo.response.TeamResponse;
import com.cuit.bbs.entity.vo.query.TeamQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 讨论组表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class TeamServiceImpl extends BaseServiceImpl<Team> implements ITeamService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private TeamDao teamDao;
        @Resource
        private BaseConverter<TeamRequest, Team>  requestConverter;
        @Resource
        private BaseConverter<Team, TeamResponse> responseConverter;

        @Override
        public Integer saveTeam(TeamRequest request) throws Exception {
            Team team = requestConverter.convert(request, Team.class);
            return teamDao.insert(team);
        }

        @Override
        public Integer updateTeam(TeamRequest request) throws Exception {
            Team team = requestConverter.convert(request, Team.class);
            return teamDao.update(team);
        }

        @Override
        public List<TeamResponse> findListTeam(TeamQuery query) throws Exception {
            List<Team> teamList = teamDao.findQuery(query);
            //TODO
            List<TeamResponse> teamResponse = responseConverter.convert(teamList,TeamResponse.class );
            return teamResponse;
        }

        @Override
        public PageResult<TeamResponse> findPageTeam(TeamQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListTeam(query));
        }
}
