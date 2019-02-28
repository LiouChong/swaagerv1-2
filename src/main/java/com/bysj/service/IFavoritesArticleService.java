package com.bysj.service;

import com.antiy.common.base.IBaseService;
import com.antiy.common.base.PageResult;
import java.io.Serializable;
import java.util.List;

import com.cuit.bbs.entity.dto.FavoritesArticleDTO;
import com.cuit.bbs.entity.vo.query.FavoritesArticleQuery;
import com.cuit.bbs.entity.vo.request.FavoritesArticleRequest;
import com.cuit.bbs.entity.vo.response.FavoritesArticleResponse;
import com.cuit.bbs.entity.FavoritesArticle;


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
         * @return
         */
        Integer updateFavoritesArticle(FavoritesArticleRequest request) throws Exception;

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

}
