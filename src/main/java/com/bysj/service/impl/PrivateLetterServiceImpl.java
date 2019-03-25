package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.PrivateLetterDao;
import com.bysj.entity.PrivateLetter;
import com.bysj.entity.vo.query.PrivateLetterQuery;
import com.bysj.entity.vo.request.PrivateLetterRequest;
import com.bysj.entity.vo.response.PrivateLetterResponse;
import com.bysj.service.IPrivateLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
            // 发送者的接收者 已经设值
            // 用户发送发的发送者
            privateLetter.setUserSendSend(userId);
            //  用于接受方的发送者
            privateLetter.setUserRevSend(request.getUserSendRev());

            // TODO:考虑黑名单功能
            if (privateLetterDao.insert(privateLetter) == 1) {
                return "发送成功";
            } else {
                return "发送失败";
            }
        }

        @Override
        public Integer updatePrivateLetter(PrivateLetterRequest request) throws Exception {
            PrivateLetter privateLetter = requestConverter.convert(request, PrivateLetter.class);
            return privateLetterDao.update(privateLetter);
        }

        @Override
        public List<PrivateLetterResponse> findListPrivateLetter(PrivateLetterQuery query) throws Exception {
            List<PrivateLetter> privateLetterList = privateLetterDao.findQuery(query);
            //TODO
            List<PrivateLetterResponse> privateLetterResponse = responseConverter.convert(privateLetterList,PrivateLetterResponse.class );
            return privateLetterResponse;
        }

        @Override
        public PageResult<PrivateLetterResponse> findPagePrivateLetter(PrivateLetterQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListPrivateLetter(query));
        }
}
