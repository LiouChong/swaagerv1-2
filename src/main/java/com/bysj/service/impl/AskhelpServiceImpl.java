package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.dao.AskhelpDao;
import com.bysj.entity.Askhelp;
import com.bysj.entity.vo.query.AskhelpQuery;
import com.bysj.entity.vo.request.AskhelpRequest;
import com.bysj.entity.vo.response.AskhelpResponse;
import com.bysj.service.IAskhelpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 求问表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class AskhelpServiceImpl extends BaseServiceImpl<Askhelp> implements IAskhelpService {

    @Resource
    private AskhelpDao askhelpDao;
    @Resource
    private BaseConverter<AskhelpRequest, Askhelp> requestConverter;
    @Resource
    private BaseConverter<Askhelp, AskhelpResponse> responseConverter;

    @Override
    public Integer saveAskhelp(AskhelpRequest request) throws Exception {
        Askhelp askhelp = requestConverter.convert(request, Askhelp.class);
        return askhelpDao.insert(askhelp);
    }

    @Override
    public Integer updateAskhelp(AskhelpRequest request) throws Exception {
        Askhelp askhelp = requestConverter.convert(request, Askhelp.class);
        return askhelpDao.update(askhelp);
    }

    @Override
    public List<AskhelpResponse> findListAskhelp(AskhelpQuery query) throws Exception {
        List<Askhelp> askhelpList = askhelpDao.findQuery(query);

        //TODO
        List<AskhelpResponse> askhelpResponse = responseConverter.convert(askhelpList, AskhelpResponse.class);
        return askhelpResponse;
    }

    @Override
    public PageResult<AskhelpResponse> findPageAskhelp(AskhelpQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListAskhelp(query));
    }
}
