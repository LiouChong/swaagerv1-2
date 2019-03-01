package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.Resource;
import com.bysj.entity.vo.query.ResourceQuery;
import com.bysj.entity.vo.request.ResourceRequest;
import com.bysj.entity.vo.response.ResourceResponse;

import java.util.List;

/**
 * <p>
 * 上传的资源表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IResourceService extends IBaseService<Resource> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer saveResource(ResourceRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updateResource(ResourceRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<ResourceResponse> findListResource(ResourceQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<ResourceResponse> findPageResource(ResourceQuery query) throws Exception;

}
