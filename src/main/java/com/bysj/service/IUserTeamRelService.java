package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.UserTeamRelDTO;
import com.cuit.bbs.entity.vo.query.UserTeamRelQuery;
import com.cuit.bbs.entity.vo.request.UserTeamRelRequest;
import com.cuit.bbs.entity.vo.response.UserTeamRelResponse;
import com.cuit.bbs.entity.UserTeamRel;


/**
 * <p>
 * 用户小组关联表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IUserTeamRelService extends IBaseService<UserTeamRel> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveUserTeamRel(UserTeamRelRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateUserTeamRel(UserTeamRelRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<UserTeamRelResponse> findListUserTeamRel(UserTeamRelQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<UserTeamRelResponse> findPageUserTeamRel(UserTeamRelQuery query) throws Exception;

}
