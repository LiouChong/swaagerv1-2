package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.User;
import com.cuit.bbs.dao.UserDao;
import com.cuit.bbs.service.IUserService;
import com.cuit.bbs.entity.dto.User;
import com.cuit.bbs.entity.vo.request.UserRequest;
import com.cuit.bbs.entity.vo.response.UserResponse;
import com.cuit.bbs.entity.vo.query.UserQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private UserDao userDao;
        @Resource
        private BaseConverter<UserRequest, User>  requestConverter;
        @Resource
        private BaseConverter<User, UserResponse> responseConverter;

        @Override
        public Integer saveUser(UserRequest request) throws Exception {
            User user = requestConverter.convert(request, User.class);
            return userDao.insert(user);
        }

        @Override
        public Integer updateUser(UserRequest request) throws Exception {
            User user = requestConverter.convert(request, User.class);
            return userDao.update(user);
        }

        @Override
        public List<UserResponse> findListUser(UserQuery query) throws Exception {
            List<User> userList = userDao.findQuery(query);
            //TODO
            List<UserResponse> userResponse = responseConverter.convert(userList,UserResponse.class );
            return userResponse;
        }

        @Override
        public PageResult<UserResponse> findPageUser(UserQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListUser(query));
        }
}
