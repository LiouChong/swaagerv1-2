package com.bysj.common.utils;

import com.bysj.dao.UserDao;
import com.bysj.entity.User;
import com.bysj.entity.vo.response.UserResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author liuchong
 */
@Component
public class UserHandle {

    @Resource
    private UserDao userDao;

    public Integer getUserId() {
        return getUser().getId();
    }

    public String getUserEmail() {
        return getUser().getEmail();
    }

    public User getUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public UserResponse getCurrentUserInfo() {
        return userDao.userDetailInfo(getUserId());
    }
}
