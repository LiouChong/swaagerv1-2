package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.dao.PermissionDao;
import com.bysj.entity.Permission;
import com.bysj.entity.vo.query.PermissionQuery;
import com.bysj.entity.vo.request.PermissionRequest;
import com.bysj.entity.vo.response.PermissionResponse;
import com.bysj.service.IPermissionService;
import org.springframework.stereotype.Service;

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
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {



        @Resource
        private PermissionDao permissionDao;
        @Resource
        private BaseConverter<PermissionRequest, Permission> requestConverter;
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
