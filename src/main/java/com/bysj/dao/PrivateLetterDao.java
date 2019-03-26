package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.PrivateLetter;
import com.bysj.entity.vo.query.PrivateLetterForMyManageQuery;
import com.bysj.entity.vo.response.PrivateLetterForMyResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 私信表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface PrivateLetterDao extends IBaseDao<PrivateLetter> {
    /**
     * 查询我发送的私信
     * @param userId
     * @return
     */
    List<PrivateLetterForMyResponse> getMySendLetter(@Param("userId") Integer userId);

    /**
     * 查询我接收的私信
     * @param userId
     * @return
     */
    List<PrivateLetterForMyResponse> getMyRevLetter(@Param("userId") Integer userId);

    /**
     * 查询发送私信数量
     * @param userId
     * @return
     */
    Integer getMySendLetterCount(@Param("userId") Integer userId);

    /**
     * 查询接收私信数量
     * @param userId
     * @return
     */
    Integer getMyRevLetterCount(@Param("userId") Integer userId);

}
