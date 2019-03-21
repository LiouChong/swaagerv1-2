package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.UserHandle;
import com.bysj.dao.FavoritesArticleDao;
import com.bysj.entity.FavoritesArticle;
import com.bysj.entity.vo.query.FavoritesArticleQuery;
import com.bysj.entity.vo.request.FavoritesArticleRequest;
import com.bysj.entity.vo.response.FavoritesArticleResponse;
import com.bysj.service.IFavoritesArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 喜欢的文章表 服务实现类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
@Service
public class FavoritesArticleServiceImpl extends BaseServiceImpl<FavoritesArticle> implements IFavoritesArticleService {
        @Resource
        private FavoritesArticleDao favoritesArticleDao;
        @Resource
        private BaseConverter<FavoritesArticleRequest, FavoritesArticle> requestConverter;
        @Resource
        private BaseConverter<FavoritesArticle, FavoritesArticleResponse> responseConverter;

        @Autowired
        private UserHandle userHandle;

        @Override
        public Integer saveFavoritesArticle(FavoritesArticleRequest request) throws Exception {
            FavoritesArticle favoritesArticle = requestConverter.convert(request, FavoritesArticle.class);

            Date nowDate = new Date();
            Integer userId = userHandle.getUserId();

            // 设置4个属性和收藏者id
            favoritesArticle.setGmtCreate(nowDate);
            favoritesArticle.setGmtModify(nowDate);
            favoritesArticle.setUserId(userId);
            favoritesArticle.setUserModify(userId);
            favoritesArticle.setUserCreate(userId);

            return favoritesArticleDao.insert(favoritesArticle);
        }

        @Override
        public Integer updateFavoritesArticle(FavoritesArticleRequest request, Integer state) throws Exception {
            FavoritesArticle favoritesArticle = requestConverter.convert(request, FavoritesArticle.class);
            Integer userId = userHandle.getUserId();

            favoritesArticle.setUserId(userId);
            favoritesArticle.setUserCreate(userId);
            favoritesArticle.setGmtModify(new Date());
            favoritesArticle.setState(state);

            return favoritesArticleDao.update(favoritesArticle);
        }

        @Override
        public List<FavoritesArticleResponse> findListFavoritesArticle(FavoritesArticleQuery query) throws Exception {
            List<FavoritesArticle> favoritesArticleList = favoritesArticleDao.findQuery(query);
            //TODO
            List<FavoritesArticleResponse> favoritesArticleResponse = responseConverter.convert(favoritesArticleList,FavoritesArticleResponse.class );
            return favoritesArticleResponse;
        }

        @Override
        public PageResult<FavoritesArticleResponse> findPageFavoritesArticle(FavoritesArticleQuery query) throws Exception {
            return new PageResult<>(query.getPageSize(), this.findCount(query),query.getCurrentPage(), this.findListFavoritesArticle(query));
        }

    @Override
    public FavoritesArticle getIfCollectByUserId(Integer userId, Integer postId) {
        return favoritesArticleDao.getIfCollectByUserId(userId, postId);
    }
}
