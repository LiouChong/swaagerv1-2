package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.request.PageResult;
import com.bysj.entity.Permission;
import com.bysj.entity.vo.query.PermissionQuery;
import com.bysj.entity.vo.request.PermissionRequest;
import com.bysj.entity.vo.response.PermissionResponse;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IPermissionService extends IBaseService<Permission> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer savePermission(PermissionRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updatePermission(PermissionRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<PermissionResponse> findListPermission(PermissionQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<PermissionResponse> findPagePermission(PermissionQuery query) throws Exception;

}
