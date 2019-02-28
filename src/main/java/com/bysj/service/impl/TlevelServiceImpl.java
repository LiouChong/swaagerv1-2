package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Tlevel;
import com.cuit.bbs.dao.TlevelDao;
import com.cuit.bbs.service.ITlevelService;
import com.cuit.bbs.entity.dto.Tlevel;
import com.cuit.bbs.entity.vo.request.TlevelRequest;
import com.cuit.bbs.entity.vo.response.TlevelResponse;
import com.cuit.bbs.entity.vo.query.TlevelQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class TlevelServiceImpl extends BaseServiceImpl<Tlevel> implements ITlevelService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private TlevelDao tlevelDao;
        @Resource
        private BaseConverter<TlevelRequest, Tlevel>  requestConverter;
        @Resource
        private BaseConverter<Tlevel, TlevelResponse> responseConverter;

        @Override
        public Integer saveTlevel(TlevelRequest request) throws Exception {
            Tlevel tlevel = requestConverter.convert(request, Tlevel.class);
            return tlevelDao.insert(tlevel);
        }

        @Override
        public Integer updateTlevel(TlevelRequest request) throws Exception {
            Tlevel tlevel = requestConverter.convert(request, Tlevel.class);
            return tlevelDao.update(tlevel);
        }

        @Override
        public List<TlevelResponse> findListTlevel(TlevelQuery query) throws Exception {
            List<Tlevel> tlevelList = tlevelDao.findQuery(query);
            //TODO
            List<TlevelResponse> tlevelResponse = responseConverter.convert(tlevelList,TlevelResponse.class );
            return tlevelResponse;
        }

        @Override
        public PageResult<TlevelResponse> findPageTlevel(TlevelQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListTlevel(query));
        }
}
