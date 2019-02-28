package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.PrivateLetterDTO;
import com.cuit.bbs.entity.vo.query.PrivateLetterQuery;
import com.cuit.bbs.entity.vo.request.PrivateLetterRequest;
import com.cuit.bbs.entity.vo.response.PrivateLetterResponse;
import com.cuit.bbs.entity.PrivateLetter;


/**
 * <p>
 * 私信表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IPrivateLetterService extends IBaseService<PrivateLetter> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer savePrivateLetter(PrivateLetterRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @return
         */
        Integer updatePrivateLetter(PrivateLetterRequest request) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<PrivateLetterResponse> findListPrivateLetter(PrivateLetterQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<PrivateLetterResponse> findPagePrivateLetter(PrivateLetterQuery query) throws Exception;

}
