package com.bysj.service.impl;


import com.bysj.common.BaseConverter;
import com.bysj.common.BaseServiceImpl;
import com.bysj.common.PageResult;
import com.bysj.dao.UserBanDao;
import com.bysj.entity.UserBan;
import com.bysj.entity.vo.query.UserBanQuery;
import com.bysj.entity.vo.request.UserBanRequest;
import com.bysj.entity.vo.response.UserBanResponse;
import com.bysj.service.IUserBanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户封禁表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class UserBanServiceImpl extends BaseServiceImpl<UserBan> implements IUserBanService {


    @Resource
    private UserBanDao userBanDao;
    @Resource
    private BaseConverter<UserBanRequest, UserBan> requestConverter;
    @Resource
    private BaseConverter<UserBan, UserBanResponse> responseConverter;

    @Override
    public Integer saveUserBan(UserBanRequest request) throws Exception {
        UserBan userBan = requestConverter.convert(request, UserBan.class);
        return userBanDao.insert(userBan);
    }

    @Override
    public Integer updateUserBan(UserBanRequest request) throws Exception {
        UserBan userBan = requestConverter.convert(request, UserBan.class);
        return userBanDao.update(userBan);
    }

    @Override
    public List<UserBanResponse> findListUserBan(UserBanQuery query) throws Exception {
        List<UserBan> userBanList = userBanDao.findQuery(query);
        //TODO
        List<UserBanResponse> userBanResponse = responseConverter.convert(userBanList, UserBanResponse.class);
        return userBanResponse;
    }

    @Override
    public PageResult<UserBanResponse> findPageUserBan(UserBanQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListUserBan(query));
    }
}
