package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.TotalStationInformationDTO;
import com.cuit.bbs.entity.vo.query.TotalStationInformationQuery;
import com.cuit.bbs.entity.vo.request.TotalStationInformationRequest;
import com.cuit.bbs.entity.vo.response.TotalStationInformationResponse;
import com.cuit.bbs.entity.TotalStationInformation;


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
