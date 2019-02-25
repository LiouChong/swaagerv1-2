package com.bysj.service.impl;


import com.bysj.common.exception.BussinessException;
import com.bysj.common.exception.RequestParamsException;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.common.utils.MailUtil;
import com.bysj.dao.UserDao;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.request.UserRequestForLogin;
import com.bysj.entity.vo.request.UserRequestForRegist;
import com.bysj.entity.vo.response.UserResponse;
import com.bysj.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {


    @Resource
    private UserDao userDao;

    @Resource
    private BaseConverter<UserRequestForRegist, User> requestSaveConverter;

    @Resource
    private BaseConverter<UserRequest, User> requestConverter;
    @Resource
    private BaseConverter<User, UserResponse> responseConverter;

    @Override
    public String saveUser(UserRequestForRegist saveRequest, HttpServletRequest request) throws Exception {
        User user = requestSaveConverter.convert(saveRequest, User.class);
        HttpSession session = request.getSession();
        if (session.getAttribute("email") == null) {
            throw new BussinessException("请先发送验证码");
        }
        if ( (!(session.getAttribute("email").equals(user.getEmail()))) || ifRepeatEmail(user.getEmail())) {
            throw new BussinessException("400","邮箱有误！请重新填写");
        }

        int verificationCode = (int) session.getAttribute("verificationCode");

        if (!(verificationCode + "").equals(saveRequest.getCode())) {
            throw new  BussinessException("400","验证码错误！");
        } else {
            if (userDao.insert(user) == 1) {
                return "注册成功";
            } else {
                throw new BussinessException("500", "注册失败！服务器故障，请稍后再试！");
            }
        }
    }


    @Override
    public Integer updateUser(UserRequest request) throws Exception {
        User user = requestConverter.convert(request, User.class);
        return userDao.update(user);
    }

    @Override
    public List<UserResponse> findListUser(UserQuery query) throws Exception {
        List<User> userList = userDao.findQuery(query);
        //TODO
        List<UserResponse> userResponse = responseConverter.convert(userList, UserResponse.class);
        return userResponse;
    }

    @Override
    public PageResult<UserResponse> findPageUser(UserQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListUser(query));
    }

    @Override
    public String sendVerificationCode(String email, HttpServletRequest request) {
        //生成随机码
        int verificationCode  = new Random().nextInt(10000);
        if (verificationCode < 1000) {
            verificationCode += 1000;
        }

        HttpSession session = request.getSession();
        //将随机生成的验证码保存到session的verificationCode中，便于后面取出对比
        session.setAttribute("verificationCode",verificationCode);
        session.setAttribute("email",email);
        try {
            MailUtil.senMail(verificationCode,email);
        } catch (Exception e) {
            throw new BussinessException("500","服务器发送邮件发生故障！请稍后再试");
        }
        return "sucess";
    }

    @Override
    public Boolean ifRepeatEmail(String email) {
        return userDao.selectByemail(email) != null ? true: false;
    }

    @Override
    public String doLogin(UserRequestForLogin userRequestForLogin, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String email = userRequestForLogin.getEmail();
        String psw = userRequestForLogin.getPsw();

        if (email.equals("") || psw.equals("")) {
            throw new RequestParamsException("用户名或密码为空！") ;
        } else {
            if (Objects.isNull(getByEmail(email))) {
                throw new RequestParamsException("该用户名尚未被注册");
            }
            else if( !(getByEmail(email).getPsw().equals(psw))) {
                throw new RequestParamsException("密码错误！");
            }
        }
        return null;
    }

    public User getByEmail(String email) {
        return userDao.selectByemail(email);
    }
}
