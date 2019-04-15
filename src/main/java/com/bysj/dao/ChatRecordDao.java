package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.ChatRecord;
import com.bysj.entity.vo.response.ChatRecordResponse;

import java.util.List;

/**
 * <p>
 * 讨论组聊天记录表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface ChatRecordDao extends IBaseDao<ChatRecord> {
    List<ChatRecordResponse> findHistoryRecord(Integer teamId);
}
