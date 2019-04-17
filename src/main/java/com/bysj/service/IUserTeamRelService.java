package com.bysj.service;

import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import com.bysj.entity.UserTeamRel;
import com.bysj.entity.vo.query.UserTeamRelQuery;
import com.bysj.entity.vo.request.UserTeamRelExitRequest;
import com.bysj.entity.vo.request.UserTeamRelRequest;
import com.bysj.entity.vo.response.UserTeamRelResponse;

import java.util.List;

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
     *
     * @param request
     * @return
     */
    Integer saveUserTeamRel(UserTeamRelRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    Integer updateUserTeamRel(UserTeamRelRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<UserTeamRelResponse> findListUserTeamRel(UserTeamRelQuery query) throws Exception;

    /**
     * 批量查询
     *
     * @param query
     * @return
     */
    PageResult<UserTeamRelResponse> findPageUserTeamRel(UserTeamRelQuery query) throws Exception;

    Integer exitTeam(UserTeamRelExitRequest request);

}
