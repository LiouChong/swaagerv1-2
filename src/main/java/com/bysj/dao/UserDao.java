package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface UserDao extends IBaseDao<User> {
    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    User selectByemail(@Param("email") String email);

    /**
     * 根据登录用户的职位查询权限
     * @param level
     * @return
     */
    List<String> selectUserPermissionBylevel(@Param("level") Integer level);
}
