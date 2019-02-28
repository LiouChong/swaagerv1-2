package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.ChatRecord;
import com.cuit.bbs.dao.ChatRecordDao;
import com.cuit.bbs.service.IChatRecordService;
import com.cuit.bbs.entity.dto.ChatRecord;
import com.cuit.bbs.entity.vo.request.ChatRecordRequest;
import com.cuit.bbs.entity.vo.response.ChatRecordResponse;
import com.cuit.bbs.entity.vo.query.ChatRecordQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 讨论组聊天记录表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class ChatRecordServiceImpl extends BaseServiceImpl<ChatRecord> implements IChatRecordService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private ChatRecordDao chatRecordDao;
        @Resource
        private BaseConverter<ChatRecordRequest, ChatRecord>  requestConverter;
        @Resource
        private BaseConverter<ChatRecord, ChatRecordResponse> responseConverter;

        @Override
        public Integer saveChatRecord(ChatRecordRequest request) throws Exception {
            ChatRecord chatRecord = requestConverter.convert(request, ChatRecord.class);
            return chatRecordDao.insert(chatRecord);
        }

        @Override
        public Integer updateChatRecord(ChatRecordRequest request) throws Exception {
            ChatRecord chatRecord = requestConverter.convert(request, ChatRecord.class);
            return chatRecordDao.update(chatRecord);
        }

        @Override
        public List<ChatRecordResponse> findListChatRecord(ChatRecordQuery query) throws Exception {
            List<ChatRecord> chatRecordList = chatRecordDao.findQuery(query);
            //TODO
            List<ChatRecordResponse> chatRecordResponse = responseConverter.convert(chatRecordList,ChatRecordResponse.class );
            return chatRecordResponse;
        }

        @Override
        public PageResult<ChatRecordResponse> findPageChatRecord(ChatRecordQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListChatRecord(query));
        }
}
