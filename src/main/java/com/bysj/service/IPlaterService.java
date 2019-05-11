package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.entity.Plater;
import com.bysj.entity.vo.query.PlaterQuery;
import com.bysj.entity.vo.response.PlaterForUserInfoResponse;
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
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<PlaterResponse> findListPlater(PlaterQuery query) throws Exception;


    /**
     * 根据板块id查询版主名称
     *
     * @param plateId
     * @return
     */
    PlaterForUserInfoResponse getUserNameForPlate(Integer plateId);

    Integer takeOffPlate(Integer plateId);
}
