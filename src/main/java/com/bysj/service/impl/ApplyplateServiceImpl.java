package com.bysj.service.impl;


import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.dao.ApplyplateDao;
import com.bysj.entity.Applyplate;
import com.bysj.entity.vo.query.ApplyplateQuery;
import com.bysj.service.IApplyplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户申请版主表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class ApplyplateServiceImpl extends BaseServiceImpl<Applyplate> implements IApplyplateService {

    @Resource
    private ApplyplateDao applyplateDao;
    @Resource
    private BaseConverter<ApplyplateRequest, Applyplate> requestConverter;
    @Resource
    private BaseConverter<Applyplate, ApplyplateResponse> responseConverter;

    @Override
    public Integer saveApplyplate(ApplyplateRequest request) throws Exception {
        Applyplate applyplate = requestConverter.convert(request, Applyplate.class);
        applyplate.setApplyTime(new Date());
        return applyplateDao.insert(applyplate);
    }

    @Override
    public Integer updateApplyplate(ApplyplateRequest request) throws Exception {
        Applyplate applyplate = requestConverter.convert(request, Applyplate.class);
        return applyplateDao.update(applyplate);
    }

    @Override
    public List<ApplyplateResponse> findListApplyplate(ApplyplateQuery query) throws Exception {
        List<Applyplate> applyplateList = applyplateDao.findQuery(query);
        //TODO
        List<ApplyplateResponse> applyplateResponse = responseConverter.convert(applyplateList, ApplyplateResponse.class);
        return applyplateResponse;
    }

    @Override
    public PageResult<ApplyplateResponse> findPageApplyplate(ApplyplateQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListApplyplate(query));
    }
}
