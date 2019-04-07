package com.bysj.service.impl;

import com.bysj.common.exception.BussinessException;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.TeamDao;
import com.bysj.dao.UserTeamRelDao;
import com.bysj.entity.Team;
import com.bysj.entity.UserTeamRel;
import com.bysj.entity.vo.query.TeamQuery;
import com.bysj.entity.vo.request.TeamRequest;
import com.bysj.entity.vo.response.TeamDetailResponse;
import com.bysj.entity.vo.response.TeamIndexResponse;
import com.bysj.entity.vo.response.TeamResponse;
import com.bysj.entity.vo.response.UserTeamDetailResponse;
import com.bysj.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
public class TeamServiceImpl extends BaseServiceImpl<Team> implements ITeamService {
    @Resource
    private TeamDao teamDao;
    @Resource
    private BaseConverter<TeamRequest, Team> requestConverter;
    @Resource
    private BaseConverter<Team, TeamResponse> responseConverter;
    @Autowired
    private UserHandle userHandle;

    @Resource
    private UserTeamRelDao userTeamRelDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveTeam(TeamRequest request) throws Exception {
        Team team = requestConverter.convert(request, Team.class);

        Integer userId = userHandle.getLoginUserId();
        Date nowDate = new Date();

        if (checkIfOverLimie(userId)) {
            throw new BussinessException("您加入的讨论组已经到达上限");
        }

        team.setLeaderId(userId);
        team.setUserModify(userId);
        team.setGmtCreate(nowDate);
        team.setGmtModify(nowDate);

        team.setMemberCount(1);
        team.setState(1);
        teamDao.insert(team);

        UserTeamRel userTeamRel = new UserTeamRel();
        userTeamRel.setGmtCreate(nowDate);
        userTeamRel.setGmtModify(nowDate);
        userTeamRel.setUserId(userId);
        userTeamRel.setTeamId(team.getId());


        return userTeamRelDao.insert(userTeamRel);
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

    private boolean checkIfOverLimie(Integer userId) {
        Integer count = userTeamRelDao.selectUserTeamCount(userId);
        return userTeamRelDao.selectUserTeamCount(userId) > 4;
    }

    @Override
    public List<TeamIndexResponse> selectForIndex(Integer userId) {
        return teamDao.selectForPageIndex(userId);
    }

    @Override
    public TeamDetailResponse getDetail(Integer teamId) {
        TeamDetailResponse teamDetailResponse = teamDao.selectDetailBtId(teamId);
        teamDetailResponse.setGmtCreateStr(
                DateUtils.getDataString(teamDetailResponse.getGmtCreate(), DateUtils.WHOLE_FORMAT));
        List<UserTeamDetailResponse> responses = userTeamRelDao.selectUsersFromTeamId(teamId);
        teamDetailResponse.setNicknames(responses);
        return teamDetailResponse;
    }
}
