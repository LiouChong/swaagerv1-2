package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.PermissionDTO;
import com.cuit.bbs.entity.vo.query.PermissionQuery;
import com.cuit.bbs.entity.vo.request.PermissionRequest;
import com.cuit.bbs.entity.vo.response.PermissionResponse;
import com.cuit.bbs.entity.Permission;


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
