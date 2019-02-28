package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.Plate;
import com.bysj.entity.vo.query.PlateQuery;

import java.util.List;

/**
 * <p>
 * 板块列表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
public interface IPlateService extends IBaseService<Plate> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer savePlate(PlateRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updatePlate(PlateRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<PlateResponse> findListPlate(PlateQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<PlateResponse> findPagePlate(PlateQuery query) throws Exception;

}
