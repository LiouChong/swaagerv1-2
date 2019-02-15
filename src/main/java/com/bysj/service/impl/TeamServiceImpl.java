package com.bysj.service.impl;


import com.bysj.common.BaseConverter;
import com.bysj.common.BaseServiceImpl;
import com.bysj.common.PageResult;
import com.bysj.dao.TeamDao;
import com.bysj.entity.Team;
import com.bysj.entity.vo.query.TeamQuery;
import com.bysj.entity.vo.request.TeamRequest;
import com.bysj.entity.vo.response.TeamResponse;
import com.bysj.service.ITeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讨论组表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class TeamServiceImpl extends BaseServiceImpl<Team> implements ITeamService {
    @Resource
    private TeamDao teamDao;
    @Resource
    private BaseConverter<TeamRequest, Team> requestConverter;
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
        List<TeamResponse> teamResponse = responseConverter.convert(teamList, TeamResponse.class);
        return teamResponse;
    }

    @Override
    public PageResult<TeamResponse> findPageTeam(TeamQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListTeam(query));
    }
}
