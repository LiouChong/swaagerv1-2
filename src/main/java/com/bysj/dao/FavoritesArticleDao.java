package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.FavoritesArticle;
import com.bysj.entity.vo.query.FavoritesArticleQuery;
import com.bysj.entity.vo.response.FavoritesArticleResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    FavoritesArticle getIfCollectByUserId(@Param("userId") Integer userId,@Param("postId") Integer postId);

    /**
     * 根据用户id和帖子id查询收藏信息
     * @param userId
     * @param postId
     * @return
     */
    FavoritesArticle getByTwoId(@Param("userId") Integer userId,@Param("postId") Integer postId);

    /**
     * 分页查询收藏的帖子列表
     * @param favoritesArticleQuery
     * @return
     */
    List<FavoritesArticleResponse> findLikePostQuery(FavoritesArticleQuery favoritesArticleQuery);

    /**
     * 查询搜藏的帖子数量
     * @param query
     * @return
     */
    Integer getLikeCount(FavoritesArticleQuery query);
}
