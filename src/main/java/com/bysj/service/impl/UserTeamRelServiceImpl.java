package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.UserTeamRel;
import com.cuit.bbs.dao.UserTeamRelDao;
import com.cuit.bbs.service.IUserTeamRelService;
import com.cuit.bbs.entity.dto.UserTeamRel;
import com.cuit.bbs.entity.vo.request.UserTeamRelRequest;
import com.cuit.bbs.entity.vo.response.UserTeamRelResponse;
import com.cuit.bbs.entity.vo.query.UserTeamRelQuery;


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
public class UserTeamRelServiceImpl extends BaseServiceImpl<UserTeamRel> implements IUserTeamRelService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private UserTeamRelDao userTeamRelDao;
        @Resource
        private BaseConverter<UserTeamRelRequest, UserTeamRel>  requestConverter;
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
            List<UserTeamRelResponse> userTeamRelResponse = responseConverter.convert(userTeamRelList,UserTeamRelResponse.class );
            return userTeamRelResponse;
        }

        @Override
        public PageResult<UserTeamRelResponse> findPageUserTeamRel(UserTeamRelQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListUserTeamRel(query));
        }
}
