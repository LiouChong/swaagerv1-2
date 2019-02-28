package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Plater;
import com.cuit.bbs.dao.PlaterDao;
import com.cuit.bbs.service.IPlaterService;
import com.cuit.bbs.entity.dto.Plater;
import com.cuit.bbs.entity.vo.request.PlaterRequest;
import com.cuit.bbs.entity.vo.response.PlaterResponse;
import com.cuit.bbs.entity.vo.query.PlaterQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 板块表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class PlaterServiceImpl extends BaseServiceImpl<Plater> implements IPlaterService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private PlaterDao platerDao;
        @Resource
        private BaseConverter<PlaterRequest, Plater>  requestConverter;
        @Resource
        private BaseConverter<Plater, PlaterResponse> responseConverter;

        @Override
        public Integer savePlater(PlaterRequest request) throws Exception {
            Plater plater = requestConverter.convert(request, Plater.class);
            return platerDao.insert(plater);
        }

        @Override
        public Integer updatePlater(PlaterRequest request) throws Exception {
            Plater plater = requestConverter.convert(request, Plater.class);
            return platerDao.update(plater);
        }

        @Override
        public List<PlaterResponse> findListPlater(PlaterQuery query) throws Exception {
            List<Plater> platerList = platerDao.findQuery(query);
            //TODO
            List<PlaterResponse> platerResponse = responseConverter.convert(platerList,PlaterResponse.class );
            return platerResponse;
        }

        @Override
        public PageResult<PlaterResponse> findPagePlater(PlaterQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListPlater(query));
        }
}
