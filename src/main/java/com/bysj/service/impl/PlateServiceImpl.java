package com.bysj.service.impl;


import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.dao.PlateDao;
import com.bysj.entity.Plate;
import com.bysj.entity.vo.query.PlateQuery;
import com.bysj.entity.vo.request.PlateRequest;
import com.bysj.entity.vo.response.PlateResponse;
import com.bysj.service.IPlateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 板块列表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class PlateServiceImpl extends BaseServiceImpl<Plate> implements IPlateService {


    @Resource
    private PlateDao plateDao;
    @Resource
    private BaseConverter<PlateRequest, Plate> requestConverter;
    @Resource
    private BaseConverter<Plate, PlateResponse> responseConverter;

    @Override
    public Integer savePlate(PlateRequest request) throws Exception {
        Plate plate = requestConverter.convert(request, Plate.class);
        return plateDao.insert(plate);
    }

    @Override
    public Integer updatePlate(PlateRequest request) throws Exception {
        Plate plate = requestConverter.convert(request, Plate.class);
        return plateDao.update(plate);
    }

    @Override
    public List<PlateResponse> findListPlate(PlateQuery query) throws Exception {
        List<Plate> plateList = plateDao.findQuery(query);
        //TODO
        List<PlateResponse> plateResponse = responseConverter.convert(plateList, PlateResponse.class);
        return plateResponse;
    }

    @Override
    public PageResult<PlateResponse> findPagePlate(PlateQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListPlate(query));
    }
}
