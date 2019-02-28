package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.UserBan;
import com.cuit.bbs.dao.UserBanDao;
import com.cuit.bbs.service.IUserBanService;
import com.cuit.bbs.entity.dto.UserBan;
import com.cuit.bbs.entity.vo.request.UserBanRequest;
import com.cuit.bbs.entity.vo.response.UserBanResponse;
import com.cuit.bbs.entity.vo.query.UserBanQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 用户封禁表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class UserBanServiceImpl extends BaseServiceImpl<UserBan> implements IUserBanService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private UserBanDao userBanDao;
        @Resource
        private BaseConverter<UserBanRequest, UserBan>  requestConverter;
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
            List<UserBanResponse> userBanResponse = responseConverter.convert(userBanList,UserBanResponse.class );
            return userBanResponse;
        }

        @Override
        public PageResult<UserBanResponse> findPageUserBan(UserBanQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListUserBan(query));
        }
}
