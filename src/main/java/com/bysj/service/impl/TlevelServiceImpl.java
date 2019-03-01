package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.request.PageResult;
import com.bysj.dao.TlevelDao;
import com.bysj.entity.Tlevel;
import com.bysj.entity.vo.query.TlevelQuery;
import com.bysj.entity.vo.request.TlevelRequest;
import com.bysj.entity.vo.response.TlevelResponse;
import com.bysj.service.ITlevelService;
import org.springframework.stereotype.Service;

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
public class TlevelServiceImpl extends BaseServiceImpl<Tlevel> implements ITlevelService {


    @Resource
    private TlevelDao tlevelDao;
    @Resource
    private BaseConverter<TlevelRequest, Tlevel> requestConverter;
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
        List<TlevelResponse> tlevelResponse = responseConverter.convert(tlevelList, TlevelResponse.class);
        return tlevelResponse;
    }

    @Override
    public PageResult<TlevelResponse> findPageTlevel(TlevelQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListTlevel(query));
    }
}
