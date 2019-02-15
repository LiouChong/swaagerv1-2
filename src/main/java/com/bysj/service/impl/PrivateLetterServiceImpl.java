package com.bysj.service.impl;


import com.bysj.common.BaseConverter;
import com.bysj.common.BaseServiceImpl;
import com.bysj.common.PageResult;
import com.bysj.dao.PrivateLetterDao;
import com.bysj.entity.PrivateLetter;
import com.bysj.entity.vo.query.PrivateLetterQuery;
import com.bysj.entity.vo.request.PrivateLetterRequest;
import com.bysj.entity.vo.response.PrivateLetterResponse;
import com.bysj.service.IPrivateLetterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 私信表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Service
public class PrivateLetterServiceImpl extends BaseServiceImpl<PrivateLetter> implements IPrivateLetterService {


    @Resource
    private PrivateLetterDao privateLetterDao;
    @Resource
    private BaseConverter<PrivateLetterRequest, PrivateLetter> requestConverter;
    @Resource
    private BaseConverter<PrivateLetter, PrivateLetterResponse> responseConverter;

    @Override
    public Integer savePrivateLetter(PrivateLetterRequest request) throws Exception {
        PrivateLetter privateLetter = requestConverter.convert(request, PrivateLetter.class);
        return privateLetterDao.insert(privateLetter);
    }

    @Override
    public Integer updatePrivateLetter(PrivateLetterRequest request) throws Exception {
        PrivateLetter privateLetter = requestConverter.convert(request, PrivateLetter.class);
        return privateLetterDao.update(privateLetter);
    }

    @Override
    public List<PrivateLetterResponse> findListPrivateLetter(PrivateLetterQuery query) throws Exception {
        List<PrivateLetter> privateLetterList = privateLetterDao.findQuery(query);
        //TODO
        List<PrivateLetterResponse> privateLetterResponse = responseConverter.convert(privateLetterList, PrivateLetterResponse.class);
        return privateLetterResponse;
    }

    @Override
    public PageResult<PrivateLetterResponse> findPagePrivateLetter(PrivateLetterQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListPrivateLetter(query));
    }
}
