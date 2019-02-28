package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.FollowDTO;
import com.cuit.bbs.entity.vo.query.FollowQuery;
import com.cuit.bbs.entity.vo.request.FollowRequest;
import com.cuit.bbs.entity.vo.response.FollowResponse;
import com.cuit.bbs.entity.Follow;


/**
 * <p>
 * 关注人表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IFollowService extends IBaseService<Follow> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveFollow(FollowRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateFollow(FollowRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<FollowResponse> findListFollow(FollowQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<FollowResponse> findPageFollow(FollowQuery query) throws Exception;

}
