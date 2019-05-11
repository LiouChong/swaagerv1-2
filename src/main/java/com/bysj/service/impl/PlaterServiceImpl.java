package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.PlaterDao;
import com.bysj.entity.Plater;
import com.bysj.entity.vo.query.PlaterQuery;
import com.bysj.entity.vo.response.PlaterForUserInfoResponse;
import com.bysj.entity.vo.response.PlaterResponse;
import com.bysj.service.IPlaterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    UserHandle userHandle;
    @Resource
    private BaseConverter<Plater, PlaterResponse> responseConverter;

    @Override
    public List<PlaterResponse> findListPlater(PlaterQuery query) throws Exception {
        List<Plater> platerList = platerDao.findQuery(query);
        //TODO
        List<PlaterResponse> platerResponse = responseConverter.convert(platerList, PlaterResponse.class);
        return platerResponse;
    }

    @Override
    public PlaterForUserInfoResponse getUserNameForPlate(Integer plateId) {
        return platerDao.getOwnerById(plateId);
    }

    @Override
    public Integer takeOffPlate(Integer plateId) {
        return platerDao.takeOffPlater(plateId, new Date(), userHandle.getUserId()) ;
    }
}
