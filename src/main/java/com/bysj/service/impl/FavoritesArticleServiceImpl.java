package com.bysj.service.impl;

import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.PageResult;
import com.antiy.common.base.BaseConverter;
import org.springframework.stereotype.Service;

import com.cuit.bbs.entity.FavoritesArticle;
import com.cuit.bbs.dao.FavoritesArticleDao;
import com.cuit.bbs.service.IFavoritesArticleService;
import com.cuit.bbs.entity.dto.FavoritesArticle;
import com.cuit.bbs.entity.vo.request.FavoritesArticleRequest;
import com.cuit.bbs.entity.vo.response.FavoritesArticleResponse;
import com.cuit.bbs.entity.vo.query.FavoritesArticleQuery;


import javax.annotation.Resource;
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
public class FavoritesArticleServiceImpl extends BaseServiceImpl<FavoritesArticle> implements IFavoritesArticleService{

        private static final Logger logger = LogUtils.get();

        @Resource
        private FavoritesArticleDao favoritesArticleDao;
        @Resource
        private BaseConverter<FavoritesArticleRequest, FavoritesArticle>  requestConverter;
        @Resource
        private BaseConverter<FavoritesArticle, FavoritesArticleResponse> responseConverter;

        @Override
        public Integer saveFavoritesArticle(FavoritesArticleRequest request) throws Exception {
            FavoritesArticle favoritesArticle = requestConverter.convert(request, FavoritesArticle.class);
            return favoritesArticleDao.insert(favoritesArticle);
        }

        @Override
        public Integer updateFavoritesArticle(FavoritesArticleRequest request) throws Exception {
            FavoritesArticle favoritesArticle = requestConverter.convert(request, FavoritesArticle.class);
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
}
