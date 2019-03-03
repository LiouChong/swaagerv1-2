package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import com.bysj.entity.Askhelp;
import com.bysj.entity.vo.query.AskhelpQuery;
import com.bysj.entity.vo.request.AskhelpRequest;
import com.bysj.entity.vo.response.AskhelpResponse;

import java.util.List;


/**
 * <p>
 * 求问表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IAskhelpService extends IBaseService<Askhelp> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveAskhelp(AskhelpRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateAskhelp(AskhelpRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<AskhelpResponse> findListAskhelp(AskhelpQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<AskhelpResponse> findPageAskhelp(AskhelpQuery query) throws Exception;

}
