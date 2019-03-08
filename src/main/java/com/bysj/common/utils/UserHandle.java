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

        return getUser().getId();
    }

    public String getUserEmail() {
        return getUser().getEmail();
    }

    public User getUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
