package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.dao.ChatRecordDao;
import com.bysj.entity.ChatRecord;
import com.bysj.entity.vo.query.ChatRecordQuery;
import com.bysj.entity.vo.request.ChatRecordRequest;
import com.bysj.entity.vo.response.ChatRecordResponse;
import com.bysj.service.IChatRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class ChatRecordServiceImpl extends BaseServiceImpl<ChatRecord> implements IChatRecordService {
    @Resource
    private ChatRecordDao chatRecordDao;
    @Resource
    private BaseConverter<ChatRecordRequest, ChatRecord> requestConverter;
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
        List<ChatRecordResponse> chatRecordResponse = responseConverter.convert(chatRecordList, ChatRecordResponse.class);
        return chatRecordResponse;
    }

    @Override
    public PageResult<ChatRecordResponse> findPageChatRecord(ChatRecordQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListChatRecord(query));
    }

    @Override
    public List<ChatRecordResponse> findHistoryRecord(Integer teamId) {
        return chatRecordDao.findHistoryRecord(teamId);
    }

}

