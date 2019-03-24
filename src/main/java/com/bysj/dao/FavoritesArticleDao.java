package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.FavoritesArticle;
import org.apache.ibatis.annotations.Param;

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
}
