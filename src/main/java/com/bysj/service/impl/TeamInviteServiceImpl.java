package com.bysj.service.impl;

import com.bysj.common.exception.BussinessException;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.TeamDao;
import com.bysj.dao.TeamInviteDao;
import com.bysj.dao.UserDao;
import com.bysj.dao.UserTeamRelDao;
import com.bysj.entity.Team;
import com.bysj.entity.TeamInvite;
import com.bysj.entity.User;
import com.bysj.entity.UserTeamRel;
import com.bysj.entity.vo.query.TeamInviteQuery;
import com.bysj.entity.vo.request.TeamInviteRequest;
import com.bysj.entity.vo.request.TeamInviteUpdateRequest;
import com.bysj.entity.vo.response.TeamInviteMResponse;
import com.bysj.entity.vo.response.TeamInviteResponse;
import com.bysj.service.ITeamInviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-04-07
 */
@Service
public class TeamInviteServiceImpl extends BaseServiceImpl<TeamInvite> implements ITeamInviteService {

    @Resource
    private TeamInviteDao teamInviteDao;

    @Resource
    private BaseConverter<TeamInviteRequest, TeamInvite> requestConverter;

    @Resource
    private BaseConverter<TeamInviteUpdateRequest, TeamInvite> requestUpdateConverter;

    @Resource
    private BaseConverter<TeamInvite, TeamInviteResponse> responseConverter;

    @Resource
    private UserDao userDao;

    @Autowired
    private UserHandle userHandle;

    @Resource
    private UserTeamRelDao userTeamRelDao;

    @Resource
    private TeamDao teamDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveTeamInvite(TeamInviteRequest request) throws Exception {
        TeamInvite teamInvite = requestConverter.convert(request, TeamInvite.class);
        User bynickname = userDao.getBynickname(request.getNickname());
        if (Objects.isNull(bynickname)) {
            throw new BussinessException("该用户不存在！");
        }
       // 检查是否重复邀请
        checkIfRepeatInvite(request.getTeamId(), bynickname.getId());
        Date date = new Date();
        Integer userId = userHandle.getUserId();

        teamInvite.setUserId(bynickname.getId());

        teamInvite.setState(1);
        setDefaultValue(teamInvite);

        return teamInviteDao.insert(teamInvite);
    }
    private void checkIfRepeatInvite(Integer teamId, Integer userId) throws Exception {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("teamId", teamId);
        hashMap.put("userId", userId);
        if (teamInviteDao.getByWhere(hashMap) .size() != 0 ) {
            throw new BussinessException("请勿重复邀请！");
        }
    }
    private void setDefaultValue(TeamInvite teamInvite) {
        Date date = new Date();
        Integer nowUser = userHandle.getUserId();
        teamInvite.setGmtCreate(date);
        teamInvite.setGmtModify(date);
        teamInvite.setUserCreate(nowUser);
        teamInvite.setUserModify(nowUser);
    }
    @Override
    public Integer updateTeamInvite(TeamInviteUpdateRequest request) throws Exception {
        // 删除邀请表
        delInvite(request);

        // 检查是否已经加入改组
        checkIfInTeam(request);

        userJoinTeam(request);

        addUserCount(request);

        return 1;
    }

    private void delInvite(TeamInviteUpdateRequest request) throws Exception {
        // 对邀请表进行删除
        TeamInvite teamInvite = new TeamInvite();
        teamInvite.setId(request.getId());
        teamInvite.setState(0);
        teamInvite.setGmtModify(new Date());
        teamInviteDao.update(teamInvite);
    }
    private void checkIfInTeam(TeamInviteUpdateRequest request) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("teamId", request.getTeamId());
        hashMap.put("userId", userHandle.getUserId());
        List<UserTeamRel> byWhere = userTeamRelDao.getByWhere(hashMap);
        if ( byWhere.size() != 0) {

            throw new BussinessException("您已加入该组");
        }
    }

    private void userJoinTeam(TeamInviteUpdateRequest request) throws Exception {
        // 添加讨论组和用户的关联关系
        UserTeamRel userTeamRel = new UserTeamRel();
        Date date = new Date();
        userTeamRel.setGmtModify(date);
        userTeamRel.setState(1);
        userTeamRel.setGmtCreate(date);
        userTeamRel.setUserId(userHandle.getUserId());
        userTeamRel.setTeamId(request.getTeamId());

        userTeamRelDao.insert(userTeamRel);
    }

    private void addUserCount(TeamInviteUpdateRequest request) throws Exception {
        Team team = teamDao.getById(request.getTeamId());
        team.setMemberCount(team.getMemberCount() + 1);
        teamDao.update(team);
    }
    @Override
    public List<TeamInviteResponse> findListTeamInvite(TeamInviteQuery query) throws Exception {
        List<TeamInvite> teamInviteList = teamInviteDao.findQuery(query);
        //TODO
        List<TeamInviteResponse> teamInviteResponse = responseConverter.convert(teamInviteList, TeamInviteResponse.class);
        return teamInviteResponse;
    }

    @Override
    public PageResult<TeamInviteResponse> findPageTeamInvite(TeamInviteQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListTeamInvite(query));
    }

    @Override
    public  List<TeamInviteMResponse> getMyTeamInvite() {
        List<TeamInviteMResponse> my = teamInviteDao.getMy(userHandle.getUserId());
        my.forEach(item-> {
            item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
        });
        return my;
    }

    @Override
    public Integer getTeamInviteCount() {
        return teamInviteDao.getMyCount(userHandle.getUserId());
    }

    @Override
    public Integer defuseInvite(Integer teamInviteId) {
        return teamInviteDao.defuseInvite(teamInviteId, new Date());
    }
}
