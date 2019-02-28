package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.PrivateLetter;
import com.cuit.bbs.dao.PrivateLetterDao;
import com.cuit.bbs.service.IPrivateLetterService;
import com.cuit.bbs.entity.dto.PrivateLetter;
import com.cuit.bbs.entity.vo.request.PrivateLetterRequest;
import com.cuit.bbs.entity.vo.response.PrivateLetterResponse;
import com.cuit.bbs.entity.vo.query.PrivateLetterQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 私信表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class PrivateLetterServiceImpl extends BaseServiceImpl<PrivateLetter> implements IPrivateLetterService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private PrivateLetterDao privateLetterDao;
        @Resource
        private BaseConverter<PrivateLetterRequest, PrivateLetter>  requestConverter;
        @Resource
        private BaseConverter<PrivateLetter, PrivateLetterResponse> responseConverter;

        @Override
        public Integer savePrivateLetter(PrivateLetterRequest request) throws Exception {
            PrivateLetter privateLetter = requestConverter.convert(request, PrivateLetter.class);
            return privateLetterDao.insert(privateLetter);
        }

        @Override
        public Integer updatePrivateLetter(PrivateLetterRequest request) throws Exception {
            PrivateLetter privateLetter = requestConverter.convert(request, PrivateLetter.class);
            return privateLetterDao.update(privateLetter);
        }

        @Override
        public List<PrivateLetterResponse> findListPrivateLetter(PrivateLetterQuery query) throws Exception {
            List<PrivateLetter> privateLetterList = privateLetterDao.findQuery(query);
            //TODO
            List<PrivateLetterResponse> privateLetterResponse = responseConverter.convert(privateLetterList,PrivateLetterResponse.class );
            return privateLetterResponse;
        }

        @Override
        public PageResult<PrivateLetterResponse> findPagePrivateLetter(PrivateLetterQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListPrivateLetter(query));
        }
}
