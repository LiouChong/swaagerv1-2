package com.bysj.service.impl;

import com.bysj.common.exception.BussinessException;
import com.bysj.common.exception.RequestParamsException;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.ActionResponse;
import com.bysj.common.response.PageResult;
import com.bysj.common.response.RespBasicCode;
import com.bysj.common.utils.MailUtil;
import com.bysj.dao.UserDao;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.query.UserRequestForLogin;
import com.bysj.entity.vo.query.UserRequestForRegist;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.response.UserResponse;
import com.bysj.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
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

    /**
     * 保存用户，用户用户注册
     * @param saveRequest
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public ActionResponse saveUser(UserRequestForRegist saveRequest, HttpServletRequest request) throws Exception {
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

            //设置创建时间和修改时间
            user.setGmtCreate(new Date());
            user.setGmtModify(new Date());

            //利用shiro的MD5加密对密码进行加密（加上盐值）
            String psw = new Md5Hash(user.getPsw(),user.getEmail()).toString();

            user.setPsw(psw);

            user.setNickname(user.getEmail());
            if (userDao.insert(user) == 1) {
                return ActionResponse.success("注册成功");
            } else {
                throw new BussinessException("500", "注册失败！服务器故障，请稍后再试！");
            }
        }
    }


    /**
     * 更新用户
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateUser(UserRequest request) throws Exception {
        User user = requestConverter.convert(request, User.class);
        return userDao.update(user);
    }

    /**
     * 根据条件分页查询，被下面的方法调用
     * @param query
     * @return
     * @throws Exception
     */
    @Override
    public List<UserResponse> findListUser(UserQuery query) throws Exception {
        List<User> userList = userDao.findQuery(query);
        //TODO
        List<UserResponse> userResponse = responseConverter.convert(userList, UserResponse.class);
        return userResponse;
    }

    /**
     * 分页查询详情
     * @param query
     * @return
     * @throws Exception
     */
    @Override
    public PageResult<UserResponse> findPageUser(UserQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListUser(query));
    }

    /**
     * 发送邮箱
     * @param map
     * @param request
     * @return
     */
    @Override
    public String sendVerificationCode(Map map, HttpServletRequest request) {
        //生成随机码
        int verificationCode  = new Random().nextInt(10000);
        if (verificationCode < 1000) {
            verificationCode += 1000;
        }
        String email = null;
        try {
            email = (String) map.get("email");

            // TODO 这里有session不一致的BUG，因为sendMail还未执行完，session虽然已经写入，但别的地方比如提交注册那里获取的session不一致。导致提交注册那里以为邮箱还未发送。
            HttpSession session = request.getSession();
            //将随机生成的验证码保存到session的verificationCode中，便于后面取出对比
            session.setAttribute("verificationCode",verificationCode);
            session.setAttribute("email",email);
            MailUtil.senMail(verificationCode,email);
        } catch (Exception e) {
            throw new BussinessException("500","服务器发送邮件发生故障！请稍后再试");
        }

        return "sucess";
    }

    /**
     * 查询是否重名
     * @param email
     * @return
     */
    @Override
    public Boolean ifRepeatEmail(String email) {
        return userDao.selectByemail(email) != null ? true: false;
    }

    /**
     * 用户登录
     * @param userRequestForLogin
     * @return
     * @throws Exception
     */
    @Override
    public ActionResponse doLogin(UserRequestForLogin userRequestForLogin, HttpServletRequest request) throws Exception {
        //获取到邮箱和密码
        String email = userRequestForLogin.getEmail();
        String psw = userRequestForLogin.getPsw();
        //判断是否为空值
        if ("".equals(email) || "".equals(psw)) {
            throw new RequestParamsException("用户名或密码为空！") ;
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                userRequestForLogin.getEmail(), userRequestForLogin.getPsw());
        try {
            //对用户进行登录操作
            subject.login(usernamePasswordToken);
        } catch (IncorrectCredentialsException e) {
            return ActionResponse.fail(RespBasicCode.PARAMETER_ERROR,"密码错误！请重新输入！");
        } catch (UnknownAccountException e) {
            return ActionResponse.fail(RespBasicCode.PARAMETER_ERROR,"账号不存在！请先注册！");
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.ERROR,"服务器异常请稍后再试");
        }

        return ActionResponse.success("登陆成功");
    }

    public User getByEmail(String email) {
        return userDao.selectByemail(email);
    }

}
