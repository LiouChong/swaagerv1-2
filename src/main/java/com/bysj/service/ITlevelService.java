package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.Tlevel;
import com.bysj.entity.vo.query.TlevelQuery;
import com.bysj.entity.vo.request.TlevelRequest;
import com.bysj.entity.vo.response.TlevelResponse;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
public interface ITlevelService extends IBaseService<Tlevel> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer saveTlevel(TlevelRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updateTlevel(TlevelRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<TlevelResponse> findListTlevel(TlevelQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<TlevelResponse> findPageTlevel(TlevelQuery query) throws Exception;

}
