package com.bysj.service.impl;


import com.bysj.common.BaseConverter;
import com.bysj.common.BaseServiceImpl;
import com.bysj.common.PageResult;
import com.bysj.dao.UserTeamRelDao;
import com.bysj.entity.UserTeamRel;
import com.bysj.entity.vo.query.UserTeamRelQuery;
import com.bysj.entity.vo.request.UserTeamRelRequest;
import com.bysj.entity.vo.response.UserTeamRelResponse;
import com.bysj.service.IUserTeamRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户小组关联表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class UserTeamRelServiceImpl extends BaseServiceImpl<UserTeamRel> implements IUserTeamRelService {


    @Resource
    private UserTeamRelDao userTeamRelDao;
    @Resource
    private BaseConverter<UserTeamRelRequest, UserTeamRel> requestConverter;
    @Resource
    private BaseConverter<UserTeamRel, UserTeamRelResponse> responseConverter;

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
}
