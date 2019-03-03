package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.dao.TotalStationInformationDao;
import com.bysj.entity.TotalStationInformation;
import com.bysj.entity.vo.query.TotalStationInformationQuery;
import com.bysj.entity.vo.request.TotalStationInformationRequest;
import com.bysj.entity.vo.response.TotalStationInformationResponse;
import com.bysj.service.ITotalStationInformationService;
import org.springframework.stereotype.Service;

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
public class TotalStationInformationServiceImpl extends BaseServiceImpl<TotalStationInformation> implements ITotalStationInformationService {


    @Resource
    private TotalStationInformationDao totalStationInformationDao;
    @Resource
    private BaseConverter<TotalStationInformationRequest, TotalStationInformation> requestConverter;
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
        List<TotalStationInformationResponse> totalStationInformationResponse = responseConverter.convert(totalStationInformationList, TotalStationInformationResponse.class);
        return totalStationInformationResponse;
    }

    @Override
    public PageResult<TotalStationInformationResponse> findPageTotalStationInformation(TotalStationInformationQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListTotalStationInformation(query));
    }
}
