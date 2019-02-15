package com.bysj.service;


import com.bysj.common.IBaseService;
import com.bysj.common.PageResult;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.response.UserResponse;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
public interface IUserService extends IBaseService<User> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer saveUser(UserRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updateUser(UserRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<UserResponse> findListUser(UserQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<UserResponse> findPageUser(UserQuery query) throws Exception;

}
