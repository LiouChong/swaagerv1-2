package com.bysj.dao;


import com.bysj.entity.ChatRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 聊天记录表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Mapper
public interface ChatRecordDao extends IBaseDao<ChatRecord> {

}
