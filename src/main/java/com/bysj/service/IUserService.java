package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.request.UserRequestForRegist;
import com.bysj.entity.vo.response.UserResponse;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    String saveUser(UserRequestForRegist saveRequest, HttpServletRequest request) throws Exception;

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

    /**
     * 发送邮件验证码
     * @param email
     * @param request
     * @return
     */
    String sendVerificationCode(String email, HttpServletRequest request);
}
