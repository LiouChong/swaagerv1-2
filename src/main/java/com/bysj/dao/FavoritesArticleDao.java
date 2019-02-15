package com.bysj.dao;


import com.bysj.entity.FavoritesArticle;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 喜欢的文章表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-01-10
 */
@Mapper
public interface FavoritesArticleDao extends IBaseDao<FavoritesArticle> {

}
