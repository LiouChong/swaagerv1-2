package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.Plater;
import com.bysj.entity.vo.query.PlaterQuery;
import com.bysj.entity.vo.request.PlaterRequest;
import com.bysj.entity.vo.response.PlaterResponse;

import java.util.List;

/**
 * <p>
 * 板块表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IPlaterService extends IBaseService<Plater> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer savePlater(PlaterRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updatePlater(PlaterRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<PlaterResponse> findListPlater(PlaterQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<PlaterResponse> findPagePlater(PlaterQuery query) throws Exception;

}
