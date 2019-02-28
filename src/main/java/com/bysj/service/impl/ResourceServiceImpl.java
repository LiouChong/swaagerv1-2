package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Resource;
import com.cuit.bbs.dao.ResourceDao;
import com.cuit.bbs.service.IResourceService;
import com.cuit.bbs.entity.dto.Resource;
import com.cuit.bbs.entity.vo.request.ResourceRequest;
import com.cuit.bbs.entity.vo.response.ResourceResponse;
import com.cuit.bbs.entity.vo.query.ResourceQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 上传的资源表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements IResourceService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private ResourceDao resourceDao;
        @Resource
        private BaseConverter<ResourceRequest, Resource>  requestConverter;
        @Resource
        private BaseConverter<Resource, ResourceResponse> responseConverter;

        @Override
        public Integer saveResource(ResourceRequest request) throws Exception {
            Resource resource = requestConverter.convert(request, Resource.class);
            return resourceDao.insert(resource);
        }

        @Override
        public Integer updateResource(ResourceRequest request) throws Exception {
            Resource resource = requestConverter.convert(request, Resource.class);
            return resourceDao.update(resource);
        }

        @Override
        public List<ResourceResponse> findListResource(ResourceQuery query) throws Exception {
            List<Resource> resourceList = resourceDao.findQuery(query);
            //TODO
            List<ResourceResponse> resourceResponse = responseConverter.convert(resourceList,ResourceResponse.class );
            return resourceResponse;
        }

        @Override
        public PageResult<ResourceResponse> findPageResource(ResourceQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListResource(query));
        }
}
