package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Permission;
import com.cuit.bbs.dao.PermissionDao;
import com.cuit.bbs.service.IPermissionService;
import com.cuit.bbs.entity.dto.Permission;
import com.cuit.bbs.entity.vo.request.PermissionRequest;
import com.cuit.bbs.entity.vo.response.PermissionResponse;
import com.cuit.bbs.entity.vo.query.PermissionQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private PermissionDao permissionDao;
        @Resource
        private BaseConverter<PermissionRequest, Permission>  requestConverter;
        @Resource
        private BaseConverter<Permission, PermissionResponse> responseConverter;

        @Override
        public Integer savePermission(PermissionRequest request) throws Exception {
            Permission permission = requestConverter.convert(request, Permission.class);
            return permissionDao.insert(permission);
        }

        @Override
        public Integer updatePermission(PermissionRequest request) throws Exception {
            Permission permission = requestConverter.convert(request, Permission.class);
            return permissionDao.update(permission);
        }

        @Override
        public List<PermissionResponse> findListPermission(PermissionQuery query) throws Exception {
            List<Permission> permissionList = permissionDao.findQuery(query);
            //TODO
            List<PermissionResponse> permissionResponse = responseConverter.convert(permissionList,PermissionResponse.class );
            return permissionResponse;
        }

        @Override
        public PageResult<PermissionResponse> findPagePermission(PermissionQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListPermission(query));
        }
}
