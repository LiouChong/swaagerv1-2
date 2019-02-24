package com.bysj.config.shiro;

import com.bysj.dao.UserDao;
import com.bysj.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    private UserDao userDao;

    @Autowired
    public  UserRealm(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getName() {
        return "UserRealm";
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("调用realm");
        User user = (User) principalCollection.getPrimaryPrincipal();
        if (user.getIfBan()==1)
            return null;
        //查找用户权限
        List<String> permissions = userDao.selectUserPermissionBylevel(user.getLevel());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从token中获取到登录的用户名，查询数据库，返回用户信息
        String username = (String) authenticationToken.getPrincipal();
        User user = userDao.selectByemail(username);

        if (user == null)
            return null;

        return new SimpleAuthenticationInfo(user, user.getPsw(), getName());
    }
}
