package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.UserBanDTO;
import com.cuit.bbs.entity.vo.query.UserBanQuery;
import com.cuit.bbs.entity.vo.request.UserBanRequest;
import com.cuit.bbs.entity.vo.response.UserBanResponse;
import com.cuit.bbs.entity.UserBan;


/**
 * <p>
 * 用户封禁表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IUserBanService extends IBaseService<UserBan> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveUserBan(UserBanRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateUserBan(UserBanRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<UserBanResponse> findListUserBan(UserBanQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<UserBanResponse> findPageUserBan(UserBanQuery query) throws Exception;

}
