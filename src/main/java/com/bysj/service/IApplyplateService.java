package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.Applyplate;
import com.bysj.entity.vo.query.ApplyplateQuery;
import com.bysj.entity.vo.request.ApplyplateRequest;
import com.bysj.entity.vo.response.ApplyplateResponse;

import java.util.List;

/**
 * <p>
 * 用户申请版主表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
public interface IApplyplateService extends IBaseService<Applyplate> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer saveApplyplate(ApplyplateRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updateApplyplate(ApplyplateRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<ApplyplateResponse> findListApplyplate(ApplyplateQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<ApplyplateResponse> findPageApplyplate(ApplyplateQuery query) throws Exception;

}
