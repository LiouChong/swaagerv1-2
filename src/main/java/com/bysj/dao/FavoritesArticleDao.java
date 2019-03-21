package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.FavoritesArticle;

/**
 * <p>
 * 喜欢的文章表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface FavoritesArticleDao extends IBaseDao<FavoritesArticle> {

    /**
     * 根据用户id获取搜藏信息
     * @Author liuchong
     * @Date 2019/3/21 13:30
     */
    FavoritesArticle getIfCollectByUserId(Integer userId, Integer postId);

}
