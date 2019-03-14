package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.PageResult;
import com.bysj.common.response.ActionResponse;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.query.UserQueryByLevel;
import com.bysj.entity.vo.query.UserRequestForLogin;
import com.bysj.entity.vo.query.UserRequestForRegist;
import com.bysj.entity.vo.request.UserRequestForUpdate;
import com.bysj.entity.vo.response.UserBanResponse;
import com.bysj.entity.vo.response.UserLevellResponse;
import com.bysj.entity.vo.response.UserResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
         *
         * @param request
         * @return
         */
        ActionResponse saveUser(UserRequestForRegist saveRequest, HttpServletRequest request) throws Exception;

        /**
         * 修改
         *
         * @param request
         * @return
         */
        Integer updateUser(UserRequestForUpdate request) throws Exception;

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
         * @param map
         * @param request
         * @return
         */
        String sendVerificationCode(Map map,  HttpServletRequest request);

        /**
         * 检查是邮箱是否重复
         * @param email
         * @return
         */
        Boolean ifRepeatEmail(String email);

        /**
         * 用户登录验证
         * @param userRequestForLogin
         * @param request
         * @return
         * @throws Exception
         */
        ActionResponse doLogin(UserRequestForLogin userRequestForLogin, HttpServletRequest request) throws Exception;

        /**
         * 上传图片
         * @param profilePicture
         * @param model
         * @param request
         * @return
         */
        ModelAndView addPicture(MultipartFile profilePicture, ModelAndView model, HttpServletRequest request) throws Exception;

        /**
         * 根据id查询用户详情
         * @param id
         * @return
         * @throws Exception
         */
        UserResponse getInfoById(Integer id) throws Exception;

        /**
         * 获取当前用户详情
         * @return
         */
        UserResponse getCurrentUserInfo() throws Exception;

        /**
         * 根据等级查询用户
         * @param userQueryByLevel
         * @return
         */
        PageResult<UserLevellResponse> findUserByLevel(UserQueryByLevel userQueryByLevel);

        /**
         * 分页查询被封禁用户
         * @param objectQuery
         * @return
         */
        PageResult<UserBanResponse> findPageUserBan(ObjectQuery objectQuery);
}
