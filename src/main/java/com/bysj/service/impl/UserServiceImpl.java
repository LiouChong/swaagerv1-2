package com.bysj.service.impl;

import com.bysj.common.exception.BussinessException;
import com.bysj.common.exception.RequestParamsException;
import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.ActionResponse;
import com.bysj.common.response.PageResult;
import com.bysj.common.response.RespBasicCode;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.MailUtil;
import com.bysj.common.utils.NumberChineseEx;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.PlaterDao;
import com.bysj.dao.UserDao;
import com.bysj.entity.User;
import com.bysj.entity.vo.query.UserQuery;
import com.bysj.entity.vo.query.UserQueryByLevel;
import com.bysj.entity.vo.query.UserRequestForLogin;
import com.bysj.entity.vo.query.UserRequestForRegist;
import com.bysj.entity.vo.request.UserRequest;
import com.bysj.entity.vo.request.UserRequestForBan;
import com.bysj.entity.vo.request.UserRequestForUpdate;
import com.bysj.entity.vo.response.RandUserForHelpResponse;
import com.bysj.entity.vo.response.UserBanResponse;
import com.bysj.entity.vo.response.UserLevellResponse;
import com.bysj.entity.vo.response.UserResponse;
import com.bysj.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    private PlaterDao platerDao;

    @Resource
    private BaseConverter<UserRequestForRegist, User> requestSaveConverter;

    @Resource
    private BaseConverter<UserRequest, User> requestConverter;
    @Resource
    private BaseConverter<User, UserResponse> responseConverter;

    @Autowired
    private NumberChineseEx numberChineseEx;

    @Autowired
    private UserHandle userHandle;

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

            // TODO 注册时候加密已经注释，便于测试，后面解开
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
    public Integer updateUser(UserRequestForUpdate request) throws Exception {
        String email = userHandle.getUserEmail();
        String md5Psw = new Md5Hash(request.getOldPswValue(), email).toString();
        //如果填写了旧密码，就说明需要变更密码
        if (request.getOldPswValue() != null && !("".equals(request.getOldPswValue()))) {
            //如果填写的旧密码是对的，则进行变更
            if (md5Psw.equals(userHandle.getUser().getPsw())) {
                //对密码进行加密
                String md5NewPsw = new Md5Hash(request.getPsw(), email).toString();

                //对密码、修改时间、修改人赋值
                request.setPsw(md5NewPsw);
                request.setGmtModify(new Date());
                request.setUserModify(userHandle.getUserId());

                return userDao.updateUser(request);
            } else {
                throw new RequestParamsException("旧密码有误！请重新填写");
            }
        } else {
            request.setPsw(null);
            return userDao.updateUser(request);
        }
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

    /**
     * 用户上传图片
     * @param profilePicture
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public String addPicture(MultipartFile profilePicture, HttpServletRequest request) throws Exception {
        if (profilePicture.getSize() > 2097152) {
            return "超出图片大小限制！";
        }
//        String fileName = user_picture.getEmail() + System.currentTimeMillis();

        // 获取上传的文件名字
        String fileName = profilePicture.getOriginalFilename();
        // 通过文件名获取文件后缀
        String suffixname = fileName.substring(fileName.lastIndexOf(".") + 1);
        // TODO: 这里记得修改为当前登录用户
        System.out.println("------------->>> " + suffixname);
        String pictureName = userHandle.getUserEmail() + System.currentTimeMillis() + "." + suffixname;
        try {
            // 保存文件
            profilePicture.transferTo(new File(pictureName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        user.setPicture(pictureName);

        user.setGmtModify(new Date());
        user.setUserModify(user.getId());
        if (userDao.update(user) == 1 ) {
            return "更改成功!";
        } else {
            return "更改失败！请稍后再试";
        }
    }

    @Override
    public UserResponse getInfoById(Integer id) throws Exception {
        UserResponse userResponse = userDao.userDetailInfo(id);
        List<String> plateNames = platerDao.findPlateNameByUserId(id);

        userResponse.setPlateName(plateNames);
        userResponse.setSexStr(numberChineseEx.numExchangeChinese(userResponse, "sex"));
        userResponse.setStateStr(numberChineseEx.numExchangeChinese(userResponse, "state"));

        userResponse.setGmtCreateStr(DateUtils.getDataString(userResponse.getGmtCreate(), DateUtils.WHOLE_FORMAT));

        return userResponse;
    }

    @Override
    public PageResult<UserLevellResponse> findUserByLevel(UserQueryByLevel userQueryByLevel) {
        return new PageResult<>(userQueryByLevel.getPageSize(),
                this.findLevelCount(userQueryByLevel), userQueryByLevel.getCurrentPage(),
                this.findListUserByLevel(userQueryByLevel));
    }

    private Integer findLevelCount(UserQueryByLevel queryByLevel) {
        return userDao.findCountByLevel(queryByLevel);
    }

    private List<UserLevellResponse> findListUserByLevel(UserQueryByLevel userQueryByLevel) {
        return userDao.findUserByLevel(userQueryByLevel);
    }

    @Override
    public UserResponse getCurrentUserInfo() throws Exception {
        Integer currentUserId = userHandle.getUserId();
        return getInfoById(currentUserId);
    }

    @Override
    public PageResult<UserBanResponse> findPageUserBan(ObjectQuery objectQuery) {
        return new PageResult<>(objectQuery.getPageSize(),
                this.getBanUserCount(), objectQuery.getCurrentPage(),
                this.findBanUserList(objectQuery));
    }

    private Integer getBanUserCount() {
        return userDao.findBanUserCount();
    }

    private List<UserBanResponse> findBanUserList(ObjectQuery objectQuery) {
        return userDao.findPageBanUser(objectQuery);
    }

    @Override
    public List<RandUserForHelpResponse> findRandUser() {
        return userDao.findRandomUser();
    }

    @Override
    public String banUser(UserRequestForBan userRequestForBan) {
        userRequestForBan.setGmtModify(new Date());
        userRequestForBan.setModifyUser(userHandle.getUserId());
        if (userDao.banUser(userRequestForBan) == 1) {
            return "成功！";
        } else {
            return "失败";
        }

    }
}
