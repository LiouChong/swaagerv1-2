package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.PageResult;
import com.bysj.entity.ApplyPlate;
import com.bysj.entity.vo.request.ApplyPlatePassRequest;
import com.bysj.entity.vo.request.ApplyPlateRequest;
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
public interface IApplyPlateService extends IBaseService<ApplyPlate> {

        /**
         * 保存
         * @param request
         * @return
         */
        String saveApplyPlate(ApplyPlateRequest request) throws Exception;


        /**
         * 查询对象集合
         * @return
         */
        List<ApplyPlateResponse> findAllApply(ObjectQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<ApplyPlateResponse> findPageApplyPlate(ObjectQuery query) throws Exception;

        /**
         * 获得所有版主申请的数量
         * @return
         */
        Integer findAllCount();

        /**
         * 通过申请
         * @param request
         * @return
         */
        Integer passApply(ApplyPlatePassRequest request) throws Exception;

        Integer refuseApply(Integer applyPlateId);

}
