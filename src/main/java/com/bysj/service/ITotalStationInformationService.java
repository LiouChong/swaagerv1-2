package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.TotalStationInformation;
import com.bysj.entity.vo.query.TotalStationInformationQuery;
import com.bysj.entity.vo.request.TotalStationInformationRequest;
import com.bysj.entity.vo.response.TotalStationInformationResponse;

import java.util.List;

/**
 * <p>
 * 全站信息表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface ITotalStationInformationService extends IBaseService<TotalStationInformation> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveTotalStationInformation(TotalStationInformationRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateTotalStationInformation(TotalStationInformationRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<TotalStationInformationResponse> findListTotalStationInformation(TotalStationInformationQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<TotalStationInformationResponse> findPageTotalStationInformation(TotalStationInformationQuery query) throws Exception;

}
