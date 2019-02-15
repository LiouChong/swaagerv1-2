package com.bysj.dao;


import com.bysj.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Mapper
public interface PermissionDao extends IBaseDao<Permission> {

}
