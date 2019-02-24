package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.Follow;
import com.bysj.entity.vo.query.FollowQuery;
import com.bysj.entity.vo.request.FollowRequest;
import com.bysj.entity.vo.response.FollowResponse;

import java.util.List;

/**
 * <p>
 * 关注人列表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
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
