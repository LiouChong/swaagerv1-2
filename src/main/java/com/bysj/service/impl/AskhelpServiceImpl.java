package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Askhelp;
import com.cuit.bbs.dao.AskhelpDao;
import com.cuit.bbs.service.IAskhelpService;
import com.cuit.bbs.entity.dto.Askhelp;
import com.cuit.bbs.entity.vo.request.AskhelpRequest;
import com.cuit.bbs.entity.vo.response.AskhelpResponse;
import com.cuit.bbs.entity.vo.query.AskhelpQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 求问表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class AskhelpServiceImpl extends BaseServiceImpl<Askhelp> implements IAskhelpService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private AskhelpDao askhelpDao;
        @Resource
        private BaseConverter<AskhelpRequest, Askhelp>  requestConverter;
        @Resource
        private BaseConverter<Askhelp, AskhelpResponse> responseConverter;

        @Override
        public Integer saveAskhelp(AskhelpRequest request) throws Exception {
            Askhelp askhelp = requestConverter.convert(request, Askhelp.class);
            return askhelpDao.insert(askhelp);
        }

        @Override
        public Integer updateAskhelp(AskhelpRequest request) throws Exception {
            Askhelp askhelp = requestConverter.convert(request, Askhelp.class);
            return askhelpDao.update(askhelp);
        }

        @Override
        public List<AskhelpResponse> findListAskhelp(AskhelpQuery query) throws Exception {
            List<Askhelp> askhelpList = askhelpDao.findQuery(query);
            //TODO
            List<AskhelpResponse> askhelpResponse = responseConverter.convert(askhelpList,AskhelpResponse.class );
            return askhelpResponse;
        }

        @Override
        public PageResult<AskhelpResponse> findPageAskhelp(AskhelpQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListAskhelp(query));
        }
}
