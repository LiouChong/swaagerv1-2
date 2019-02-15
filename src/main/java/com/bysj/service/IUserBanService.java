package com.bysj.service;


import com.bysj.common.IBaseService;
import com.bysj.common.PageResult;
import com.bysj.entity.UserBan;
import com.bysj.entity.vo.query.UserBanQuery;
import com.bysj.entity.vo.request.UserBanRequest;
import com.bysj.entity.vo.response.UserBanResponse;

import java.util.List;

/**
 * <p>
 * 用户封禁表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
public interface IUserBanService extends IBaseService<UserBan> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer saveUserBan(UserBanRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updateUserBan(UserBanRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<UserBanResponse> findListUserBan(UserBanQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<UserBanResponse> findPageUserBan(UserBanQuery query) throws Exception;

}
