package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.TotalStationInformation;
import com.cuit.bbs.dao.TotalStationInformationDao;
import com.cuit.bbs.service.ITotalStationInformationService;
import com.cuit.bbs.entity.dto.TotalStationInformation;
import com.cuit.bbs.entity.vo.request.TotalStationInformationRequest;
import com.cuit.bbs.entity.vo.response.TotalStationInformationResponse;
import com.cuit.bbs.entity.vo.query.TotalStationInformationQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 全站信息表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class TotalStationInformationServiceImpl extends BaseServiceImpl<TotalStationInformation> implements ITotalStationInformationService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private TotalStationInformationDao totalStationInformationDao;
        @Resource
        private BaseConverter<TotalStationInformationRequest, TotalStationInformation>  requestConverter;
        @Resource
        private BaseConverter<TotalStationInformation, TotalStationInformationResponse> responseConverter;

        @Override
        public Integer saveTotalStationInformation(TotalStationInformationRequest request) throws Exception {
            TotalStationInformation totalStationInformation = requestConverter.convert(request, TotalStationInformation.class);
            return totalStationInformationDao.insert(totalStationInformation);
        }

        @Override
        public Integer updateTotalStationInformation(TotalStationInformationRequest request) throws Exception {
            TotalStationInformation totalStationInformation = requestConverter.convert(request, TotalStationInformation.class);
            return totalStationInformationDao.update(totalStationInformation);
        }

        @Override
        public List<TotalStationInformationResponse> findListTotalStationInformation(TotalStationInformationQuery query) throws Exception {
            List<TotalStationInformation> totalStationInformationList = totalStationInformationDao.findQuery(query);
            //TODO
            List<TotalStationInformationResponse> totalStationInformationResponse = responseConverter.convert(totalStationInformationList,TotalStationInformationResponse.class );
            return totalStationInformationResponse;
        }

        @Override
        public PageResult<TotalStationInformationResponse> findPageTotalStationInformation(TotalStationInformationQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListTotalStationInformation(query));
        }
}
