package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.TlevelDTO;
import com.cuit.bbs.entity.vo.query.TlevelQuery;
import com.cuit.bbs.entity.vo.request.TlevelRequest;
import com.cuit.bbs.entity.vo.response.TlevelResponse;
import com.cuit.bbs.entity.Tlevel;


/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface ITlevelService extends IBaseService<Tlevel> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveTlevel(TlevelRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateTlevel(TlevelRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<TlevelResponse> findListTlevel(TlevelQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<TlevelResponse> findPageTlevel(TlevelQuery query) throws Exception;

}
