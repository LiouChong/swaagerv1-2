package com.bysj.service.impl;

import com.bysj.common.request.BaseConverter;
import com.bysj.common.request.BaseServiceImpl;
import com.bysj.common.response.PageResult;
import com.bysj.common.utils.DateUtils;
import com.bysj.common.utils.NumberChineseEx;
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
    private NumberChineseEx numberChineseEx;

    @Autowired
    private UserHandle userHandle;

    @Override
    public Integer saveFavoritesArticle(FavoritesArticleRequest request) throws Exception {
        FavoritesArticle favoritesArticle = requestConverter.convert(request, FavoritesArticle.class);

        Date nowDate = new Date();
        Integer userId = userHandle.getUserId();

        if (favoritesArticleDao.getByTwoId(userId, favoritesArticle.getPostId()) != null) {
            FavoritesArticle favoritesArticle1 = favoritesArticleDao.getByTwoId(userId, favoritesArticle.getPostId());
            favoritesArticle1.setState(1);
            favoritesArticle1.setGmtModify(nowDate);
            favoritesArticle1.setUserModify(userId);
            return favoritesArticleDao.update(favoritesArticle1);
        } else {
            // 设置4个属性和收藏者id
            favoritesArticle.setGmtCreate(nowDate);
            favoritesArticle.setGmtModify(nowDate);
            favoritesArticle.setUserModify(userId);
            favoritesArticle.setUserCreate(userId);
            favoritesArticle.setUserId(userId);

            return favoritesArticleDao.insert(favoritesArticle);
        }
    }

    @Override
    public Integer updateFavoritesArticle(FavoritesArticleRequest request, Integer state) throws Exception {
        FavoritesArticle favoritesArticle = requestConverter.convert(request, FavoritesArticle.class);
        Integer userId = userHandle.getUserId();

        favoritesArticle.setUserId(userId);
        favoritesArticle.setUserModify(userId);
        favoritesArticle.setGmtModify(new Date());
        favoritesArticle.setState(state);

        return favoritesArticleDao.update(favoritesArticle);
    }

    @Override
    public List<FavoritesArticleResponse> findListFavoritesArticle(FavoritesArticleQuery query) throws Exception {
        List<FavoritesArticle> favoritesArticleList = favoritesArticleDao.findQuery(query);
        //TODO
        List<FavoritesArticleResponse> favoritesArticleResponse = responseConverter.convert(favoritesArticleList, FavoritesArticleResponse.class);
        return favoritesArticleResponse;
    }

    @Override
    public PageResult<FavoritesArticleResponse> findPageFavoritesArticle(FavoritesArticleQuery query) throws Exception {
        return new PageResult<>(query.getPageSize(), this.getLikeCount(query), query.getCurrentPage(), this.getLikePost(query));
    }

    private List<FavoritesArticleResponse> getLikePost(FavoritesArticleQuery query) {
        List<FavoritesArticleResponse> likePostQuery = favoritesArticleDao.findLikePostQuery(query);
        //对帖子集合进行数字中文转换
        likePostQuery.forEach(item -> {
            item.setIfGoodStr(numberChineseEx.numExchangeChinese(item, "ifGood"));
            item.setArticleFromStr(numberChineseEx.numExchangeChinese(item, "articleFrom"));
            item.setArticleTypeStr(numberChineseEx.numExchangeChinese(item, "articleType"));
            item.setGmtCreateStr(DateUtils.getDataString(item.getGmtCreate(), DateUtils.WHOLE_FORMAT));
            item.setGmtModifyStr(DateUtils.getDataString(item.getGmtModify(), DateUtils.WHOLE_FORMAT));
        });

        return likePostQuery;
    }
    private Integer getLikeCount(FavoritesArticleQuery query) {
        return favoritesArticleDao.getLikeCount(query);
    }

    @Override
    public FavoritesArticle getIfCollectByUserId(Integer userId, Integer postId) {
        return favoritesArticleDao.getIfCollectByUserId(userId, postId);
    }

}
