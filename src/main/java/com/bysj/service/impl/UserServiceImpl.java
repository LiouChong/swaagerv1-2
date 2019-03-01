package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.dao.UserDao;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.response.UserResponse;
import com.bysj.service.IUserService;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {



        @Resource
        private UserDao userDao;
        @Resource
        private BaseConverter<UserRequest, User> requestConverter;
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
