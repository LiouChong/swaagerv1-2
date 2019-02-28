package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.AskhelpDTO;
import com.cuit.bbs.entity.vo.query.AskhelpQuery;
import com.cuit.bbs.entity.vo.request.AskhelpRequest;
import com.cuit.bbs.entity.vo.response.AskhelpResponse;
import com.cuit.bbs.entity.Askhelp;


/**
 * <p>
 * 求问表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IAskhelpService extends IBaseService<Askhelp> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveAskhelp(AskhelpRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updateAskhelp(AskhelpRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<AskhelpResponse> findListAskhelp(AskhelpQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<AskhelpResponse> findPageAskhelp(AskhelpQuery query) throws Exception;

}
