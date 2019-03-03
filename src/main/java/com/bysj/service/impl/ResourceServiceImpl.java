package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.dao.ResourceDao;
import com.bysj.entity.Resource;
import com.bysj.entity.vo.query.ResourceQuery;
import com.bysj.entity.vo.request.ResourceRequest;
import com.bysj.entity.vo.response.ResourceResponse;
import com.bysj.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements IResourceService {

        @Autowired
        private ResourceDao resourceDao;
        @Autowired
        private BaseConverter<ResourceRequest, Resource> requestConverter;
        @Autowired
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
