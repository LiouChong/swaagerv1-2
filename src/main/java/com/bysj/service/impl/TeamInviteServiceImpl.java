package com.bysj.service.impl;

import com.bysj.common.exception.BussinessException;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.TeamInviteDao;
import com.bysj.dao.UserDao;
import com.bysj.entity.TeamInvite;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.TeamInviteQuery;
import com.bysj.entity.vo.request.TeamInviteRequest;
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
    private BaseConverter<TeamInvite, TeamInviteResponse> responseConverter;

    @Resource
    private UserDao userDao;

    @Autowired
    private UserHandle userHandle;

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
        if (teamInviteDao.getByWhere(hashMap) != null) {
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
    public Integer updateTeamInvite(TeamInviteRequest request) throws Exception {
        TeamInvite teamInvite = requestConverter.convert(request, TeamInvite.class);
        return teamInviteDao.update(teamInvite);
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
        return teamInviteDao.getMy(userHandle.getUserId());
    }
}
