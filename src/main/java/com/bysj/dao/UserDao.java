package com.bysj.dao;


import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.IBaseDao;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQueryByLevel;
import com.bysj.entity.vo.request.UserRequestForBan;
import com.bysj.entity.vo.request.UserRequestForUpdate;
import com.bysj.entity.vo.response.RandUserForHelpResponse;
import com.bysj.entity.vo.response.UserBanResponse;
import com.bysj.entity.vo.response.UserLevellResponse;
import com.bysj.entity.vo.response.UserResponse;
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

    /**
     * 获取用户详细信息
     * @param id
     * @return
     */
    UserResponse userDetailInfo(Integer id);

    /**
     * 更新用户
     * @param userRequestForUpdate
     * @return
     */
    Integer updateUser(UserRequestForUpdate userRequestForUpdate);

    /**
     * 根据等级查询数量
     * @param userQueryByLevel
     * @return
     */
    Integer findCountByLevel(UserQueryByLevel userQueryByLevel);

    /**
     * 根据等级查询用户列表
     * @param userQueryByLevel
     * @return
     */
    List<UserLevellResponse> findUserByLevel(UserQueryByLevel userQueryByLevel);

    /**
     * 分页查询被封禁用户
     * @param objectQuery
     * @return
     */
    List<UserBanResponse> findPageBanUser(ObjectQuery objectQuery);

    /**
     * 查询被封禁用户数量
     * @return
     */
    Integer findBanUserCount();

    /**
     * 随机抽选用户出来作为被邀请人
     * @return
     */
    List<RandUserForHelpResponse> findRandomUser();

    /**
     * 封禁用户
     * @param userRequestForBan
     * @return
     */
    Integer banUser(UserRequestForBan userRequestForBan);

    /**
     * 更新用户积分
     * @param userId
     * @param money
     * @return
     */
    Integer updateUserMoney(@Param("userId") Integer userId, @Param("money") Integer money);

    /**
     * 根据nickname获取用户信息
     * @param nickname
     * @return
     */
    User getBynickname(String nickname);
}
