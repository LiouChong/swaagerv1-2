package com.bysj.service;

import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import java.util.List;

import com.bysj.entity.PrivateLetter;
import com.bysj.entity.vo.query.PrivateLetterQuery;
import com.bysj.entity.vo.request.PrivateLetterRequest;
import com.bysj.entity.vo.response.PrivateLetterResponse;


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
