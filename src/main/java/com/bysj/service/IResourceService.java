package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.ResourceDTO;
import com.cuit.bbs.entity.vo.query.ResourceQuery;
import com.cuit.bbs.entity.vo.request.ResourceRequest;
import com.cuit.bbs.entity.vo.response.ResourceResponse;
import com.cuit.bbs.entity.Resource;


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
         * @param request
         * @return
         */
        Integer saveResource(ResourceRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateResource(ResourceRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<ResourceResponse> findListResource(ResourceQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<ResourceResponse> findPageResource(ResourceQuery query) throws Exception;

}
