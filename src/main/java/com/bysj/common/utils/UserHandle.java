package com.bysj.common.utils;

import com.bysj.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author liuchong
 */
@Component
public class UserHandle {

    public Integer getUserId() {
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        return user.getId();
    }

    public String getUserEmail() {
        User u = (User)SecurityUtils.getSubject().getPrincipal();
        return u.getEmail();
    }

}
