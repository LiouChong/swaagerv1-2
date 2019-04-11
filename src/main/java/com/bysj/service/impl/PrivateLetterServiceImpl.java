package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.PrivateLetterDao;
import com.bysj.entity.PrivateLetter;
import com.bysj.entity.vo.query.PrivateLetterForMyManageQuery;
import com.bysj.entity.vo.query.PrivateLetterQuery;
import com.bysj.entity.vo.request.PrivateLetterRequest;
import com.bysj.entity.vo.response.PrivateLetterForMyResponse;
import com.bysj.entity.vo.response.PrivateLetterResponse;
import com.bysj.service.IPrivateLetterService;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 私信表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class PrivateLetterServiceImpl extends BaseServiceImpl<PrivateLetter> implements IPrivateLetterService {
    @Resource
    private PrivateLetterDao privateLetterDao;
    @Resource
    private BaseConverter<PrivateLetterRequest, PrivateLetter> requestConverter;
    @Resource
    private BaseConverter<PrivateLetter, PrivateLetterResponse> responseConverter;

    @Autowired
    private UserHandle userHandle;

    @Override
    public String savePrivateLetter(PrivateLetterRequest request) throws Exception {
        PrivateLetter privateLetter = requestConverter.convert(request, PrivateLetter.class);
        Date nowDate = new Date();
        Integer userId = userHandle.getUserId();
        if (userHandle.getUserId() == null) {
            throw new UnauthenticatedException();
        }

        privateLetter.setGmtCreate(nowDate);
        privateLetter.setGmtModify(nowDate);
        privateLetter.setIfRead(0);
        privateLetter.setLetterType(1);
        privateLetter.setUserModify(userId);

        /*
            下面有三个变量用于形容私信，1个为发送方的发送者，还有发送方的接收者，最后是1个接收方的发送者
            1: 若发送方删除私信，则置 发送方发送者为null，查询有哪些私信的时候直接插发送方发送者为自己。
            2：若接收方删除私信，则置 接受放的发送者为null，查询有哪些接受的私信的时候，根据自己id查询丙炔接收方的发送者不为null
         */
        // 发送者的接收者 已经设值，此时接收者为入参。
        // 用户发送发的发送者 此时发送者为当前登录用户
        privateLetter.setUserSendSend(userId);
        //  用于接受方的发送者
        privateLetter.setUserRevSend(userId);
//        privateLetter.setUserSendRev();

        // TODO:考虑黑名单功能
        if (privateLetterDao.insert(privateLetter) == 1) {
            return "发送成功";
        } else {
            return "发送失败";
        }
    }

    @Override
    public String updatePrivateLetter(PrivateLetterRequest request) throws Exception {
        PrivateLetter privateLetter = requestConverter.convert(request, PrivateLetter.class);
        switch (request.getOperation()) {
            case "已读私信":
                setModifyValue(privateLetter);
                break;
            case "删除收到私信":
                privateLetter.setUserRevSend(0);
                setModifyValue(privateLetter);
                default:
        }

        return privateLetterDao.update(privateLetter) == 1? "成功":"失败！请稍后再试";
    }
    private void setModifyValue(PrivateLetter privateLetter) {
        privateLetter.setGmtModify(new Date());
        privateLetter.setUserModify(userHandle.getUserId());
    }

    @Override
    public List<PrivateLetterResponse> findListPrivateLetter(PrivateLetterQuery query) throws Exception {
        List<PrivateLetter> privateLetterList = privateLetterDao.findQuery(query);
        //TODO
        List<PrivateLetterResponse> privateLetterResponse = responseConverter.convert(privateLetterList, PrivateLetterResponse.class);
        return privateLetterResponse;
    }

    @Override
    public PageResult<PrivateLetterResponse> findPagePrivateLetter(PrivateLetterQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListPrivateLetter(query));
    }

    @Override
    public PageResult<PrivateLetterForMyResponse> findPageForMyManage(PrivateLetterForMyManageQuery query) {
        List<PrivateLetterForMyResponse> mySendLetter;
        List<PrivateLetterForMyResponse> myRevLetter;
        // 此时意思为查询我发送的私信
        if (Objects.isNull(query.getUserSendRev())) {
            mySendLetter = privateLetterDao.getMySendLetter(query.getUserSendSend());
            mySendLetter.forEach(item -> {
                item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
            });

            return new PageResult<>(query.getPageSize(), this.findLetterCount(query), query.getCurrentPage(), mySendLetter);
            // 查询我接收的私信
        } else {
            myRevLetter=privateLetterDao.getMyRevLetter(query.getUserSendRev());
            myRevLetter.forEach(item -> {
                item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
            });
            return new PageResult<>(query.getPageSize(), this.findLetterCount(query), query.getCurrentPage(), myRevLetter);
        }

    }

    @Override
    public Integer findLetterCount(PrivateLetterForMyManageQuery query) {
        if (Objects.isNull(query.getUserSendRev())) {
            return privateLetterDao.getMySendLetterCount(query.getUserSendSend());
        } else {
            return privateLetterDao.getMyRevLetterCount(query.getUserSendRev());
        }
    }
}
