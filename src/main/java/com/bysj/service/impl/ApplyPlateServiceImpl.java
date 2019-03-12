package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.dao.ApplyPlateDao;
import com.bysj.entity.ApplyPlate;
import com.bysj.entity.vo.query.ApplyPlateQuery;
import com.bysj.entity.vo.request.ApplyPlateRequest;
import com.bysj.entity.vo.response.ApplyPlateResponse;
import com.bysj.service.IApplyPlateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 版主申请表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-03-12
 */
@Service
public class ApplyPlateServiceImpl extends BaseServiceImpl<ApplyPlate> implements IApplyPlateService {

        @Resource
        private ApplyPlateDao applyPlateDao;
        @Resource
        private BaseConverter<ApplyPlateRequest, ApplyPlate> requestConverter;
        @Resource
        private BaseConverter<ApplyPlate, ApplyPlateResponse> responseConverter;

        @Override
        public Integer saveApplyPlate(ApplyPlateRequest request) throws Exception {
            ApplyPlate applyPlate = requestConverter.convert(request, ApplyPlate.class);
            return applyPlateDao.insert(applyPlate);
        }

        @Override
        public Integer updateApplyPlate(ApplyPlateRequest request) throws Exception {
            ApplyPlate applyPlate = requestConverter.convert(request, ApplyPlate.class);
            return applyPlateDao.update(applyPlate);
        }

        @Override
        public List<ApplyPlateResponse> findListApplyPlate(ApplyPlateQuery query) throws Exception {
            List<ApplyPlate> applyPlateList = applyPlateDao.findQuery(query);
            //TODO
            List<ApplyPlateResponse> applyPlateResponse = responseConverter.convert(applyPlateList,ApplyPlateResponse.class );
            return applyPlateResponse;
        }

        @Override
        public PageResult<ApplyPlateResponse> findPageApplyPlate(ApplyPlateQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListApplyPlate(query));
        }
}
