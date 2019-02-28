package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.ChatRecordDTO;
import com.cuit.bbs.entity.vo.query.ChatRecordQuery;
import com.cuit.bbs.entity.vo.request.ChatRecordRequest;
import com.cuit.bbs.entity.vo.response.ChatRecordResponse;
import com.cuit.bbs.entity.ChatRecord;


/**
 * <p>
 * 讨论组聊天记录表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IChatRecordService extends IBaseService<ChatRecord> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveChatRecord(ChatRecordRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateChatRecord(ChatRecordRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<ChatRecordResponse> findListChatRecord(ChatRecordQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<ChatRecordResponse> findPageChatRecord(ChatRecordQuery query) throws Exception;

}
