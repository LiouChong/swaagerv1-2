package com.bysj.service.impl;

import com.bysj.common.exception.BussinessException;
import com.bysj.common.exception.ExceptionHandle;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.dao.TeamDao;
import com.bysj.dao.TeamInviteDao;
import com.bysj.dao.UserTeamRelDao;
import com.bysj.entity.TeamInvite;
import com.bysj.entity.UserTeamRel;
import com.bysj.entity.vo.query.UserTeamRelQuery;
import com.bysj.entity.vo.request.UserTeamRelExitRequest;
import com.bysj.entity.vo.request.UserTeamRelRequest;
import com.bysj.entity.vo.response.UserTeamRelResponse;
import com.bysj.service.IUserTeamRelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户小组关联表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class UserTeamRelServiceImpl extends BaseServiceImpl<UserTeamRel> implements IUserTeamRelService {
    @Resource
    private UserTeamRelDao userTeamRelDao;
    @Resource
    private TeamDao teamDao;
    @Resource
    private BaseConverter<UserTeamRelRequest, UserTeamRel> requestConverter;
    @Resource
    private BaseConverter<UserTeamRel, UserTeamRelResponse> responseConverter;

    @Resource
    private TeamInviteDao teamInviteDao;

    @Override
    public Integer saveUserTeamRel(UserTeamRelRequest request) throws Exception {
        UserTeamRel userTeamRel = requestConverter.convert(request, UserTeamRel.class);
        return userTeamRelDao.insert(userTeamRel);
    }

    @Override
    public Integer updateUserTeamRel(UserTeamRelRequest request) throws Exception {
        UserTeamRel userTeamRel = requestConverter.convert(request, UserTeamRel.class);
        return userTeamRelDao.update(userTeamRel);
    }

    @Override
    public List<UserTeamRelResponse> findListUserTeamRel(UserTeamRelQuery query) throws Exception {
        List<UserTeamRel> userTeamRelList = userTeamRelDao.findQuery(query);
        //TODO
        List<UserTeamRelResponse> userTeamRelResponse = responseConverter.convert(userTeamRelList, UserTeamRelResponse.class);
        return userTeamRelResponse;
    }

    @Override
    public PageResult<UserTeamRelResponse> findPageUserTeamRel(UserTeamRelQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListUserTeamRel(query));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer exitTeam(UserTeamRelExitRequest request) {
        if (request.getType().equals(1)) {

            //更新关联表，删除本组内所有用户
            userTeamRelDao.clearUser(request.getTeamId());

            // 删除该小组的邀请
            teamInviteDao.deleteInvite(request.getTeamId());
            // 更新小组表
            return teamDao.exitTeam(request);

        } else {
            return userTeamRelDao.exitTeam(request);
        }
    }
}
