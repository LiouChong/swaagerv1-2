package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.FollowDao;
import com.bysj.entity.Follow;
import com.bysj.entity.vo.query.FollowQuery;
import com.bysj.entity.vo.request.FollowRequest;
import com.bysj.entity.vo.response.FollowResponse;
import com.bysj.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class FollowServiceImpl extends BaseServiceImpl<Follow> implements IFollowService {


    @Resource
    private FollowDao followDao;
    @Resource
    private BaseConverter<FollowRequest, Follow> requestConverter;
    @Resource
    private BaseConverter<Follow, FollowResponse> responseConverter;

    @Autowired
    private UserHandle userHandle;

    @Override
    public Integer saveFollow(FollowRequest request) throws Exception {
        Follow follow = requestConverter.convert(request, Follow.class);
        follow.setFanId(userHandle.getUserId());
        follow.setGmtCreate(new Date());
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
        List<FollowResponse> followResponse = responseConverter.convert(followList, FollowResponse.class);
        return followResponse;
    }

    @Override
    public PageResult<FollowResponse> findPageFollow(FollowQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.findListFollow(query));
    }

    @Override
    public Integer cancelFollow(FollowRequest followRequest) {
        Follow follow = requestConverter.convert(followRequest, Follow.class);
        follow.setFanId(userHandle.getUserId());
        return followDao.cancelFollow(follow);
    }

    @Override
    public Follow getByIds(Integer starId) {
        Follow follow = new Follow();

        follow.setStarId(starId);
        Integer userId = userHandle.getUserId();
        // 如果当前用户未登录，则返回给前端null，前端判断未null则不显示关注。
        if (userId == null) {
            return null;
        }
        follow.setFanId(userId);

        return followDao.queryByIds(follow);
    }

}
