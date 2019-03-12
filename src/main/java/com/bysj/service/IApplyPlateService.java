package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import com.bysj.entity.vo.response.ApplyPlateResponse;

import java.util.List;

/**
 * <p>
 * 版主申请表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-03-12
 */
public interface IApplyPlateService extends IBaseService<com.bysj.entity.ApplyPlate> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveApplyPlate(com.bysj.entity.vo.request.ApplyPlateRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateApplyPlate(com.bysj.entity.vo.request.ApplyPlateRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<ApplyPlateResponse> findListApplyPlate(com.bysj.entity.vo.query.ApplyPlateQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<ApplyPlateResponse> findPageApplyPlate(com.bysj.entity.vo.query.ApplyPlateQuery query) throws Exception;

}
