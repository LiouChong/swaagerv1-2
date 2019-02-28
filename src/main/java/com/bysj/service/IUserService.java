package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.UserDTO;
import com.cuit.bbs.entity.vo.query.UserQuery;
import com.cuit.bbs.entity.vo.request.UserRequest;
import com.cuit.bbs.entity.vo.response.UserResponse;
import com.cuit.bbs.entity.User;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IUserService extends IBaseService<User> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveUser(UserRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateUser(UserRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<UserResponse> findListUser(UserQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<UserResponse> findPageUser(UserQuery query) throws Exception;

}
