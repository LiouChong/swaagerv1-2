package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.dao.PlaterDao;
import com.bysj.entity.Plater;
import com.bysj.entity.vo.query.PlaterQuery;
import com.bysj.entity.vo.request.PlaterRequest;
import com.bysj.entity.vo.response.PlaterResponse;
import com.bysj.service.IPlaterService;
import org.springframework.stereotype.Service;

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
public class PlaterServiceImpl extends BaseServiceImpl<Plater> implements IPlaterService {


    @Resource
    private PlaterDao platerDao;
    @Resource
    private BaseConverter<PlaterRequest, Plater> requestConverter;
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
        List<PlaterResponse> platerResponse = responseConverter.convert(platerList, PlaterResponse.class);
        return platerResponse;
    }

    @Override
    public PageResult<PlaterResponse> findPagePlater(PlaterQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListPlater(query));
    }
}
