package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.Follow;
import com.cuit.bbs.dao.FollowDao;
import com.cuit.bbs.service.IFollowService;
import com.cuit.bbs.entity.dto.Follow;
import com.cuit.bbs.entity.vo.request.FollowRequest;
import com.cuit.bbs.entity.vo.response.FollowResponse;
import com.cuit.bbs.entity.vo.query.FollowQuery;


import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 关注人表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class FollowServiceImpl extends BaseServiceImpl<Follow> implements IFollowService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private FollowDao followDao;
        @Resource
        private BaseConverter<FollowRequest, Follow>  requestConverter;
        @Resource
        private BaseConverter<Follow, FollowResponse> responseConverter;

        @Override
        public Integer saveFollow(FollowRequest request) throws Exception {
            Follow follow = requestConverter.convert(request, Follow.class);
            return followDao.insert(follow);
        }

        @Override
        public Integer updateFollow(FollowRequest request) throws Exception {
            Follow follow = requestConverter.convert(request, Follow.class);
            return followDao.update(follow);
        }

        @Override
        public List<FollowResponse> findListFollow(FollowQuery query) throws Exception {
            List<Follow> followList = followDao.findQuery(query);
            //TODO
            List<FollowResponse> followResponse = responseConverter.convert(followList,FollowResponse.class );
            return followResponse;
        }

        @Override
        public PageResult<FollowResponse> findPageFollow(FollowQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListFollow(query));
        }
}
