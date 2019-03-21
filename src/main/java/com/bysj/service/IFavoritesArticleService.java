package com.bysj.service;


import com.bysj.common.request.IBaseService;
import com.bysj.common.response.PageResult;
import com.bysj.entity.FavoritesArticle;
import com.bysj.entity.vo.query.FavoritesArticleQuery;
import com.bysj.entity.vo.request.FavoritesArticleRequest;
import com.bysj.entity.vo.response.FavoritesArticleResponse;

import java.util.List;

/**
 * <p>
 * 喜欢的文章表 服务类
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface IFavoritesArticleService extends IBaseService<FavoritesArticle> {

        /**
         * 保存
         * @param request
         * @return
         */
        Integer saveFavoritesArticle(FavoritesArticleRequest request) throws Exception;

        /**
         * 修改
         * @param request
         * @param state
         * @return
         * @throws Exception
         */
        Integer updateFavoritesArticle(FavoritesArticleRequest request, Integer state) throws Exception;

        /**
         * 查询对象集合
         * @param query
         * @return
         */
        List<FavoritesArticleResponse> findListFavoritesArticle(FavoritesArticleQuery query) throws Exception;

        /**
         * 批量查询
         * @param query
         * @return
         */
        PageResult<FavoritesArticleResponse> findPageFavoritesArticle(FavoritesArticleQuery query) throws Exception;

        /**
         * 根据用户id查询收藏信息
         * @param id 用户id
         * @return
         */
        FavoritesArticle getIfCollectByUserId(Integer UserId, Integer postId);
}
