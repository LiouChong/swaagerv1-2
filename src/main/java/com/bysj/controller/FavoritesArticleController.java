package com.bysj.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.*;
import com.antiy.common.base.ActionResponse;
import javax.annotation.Resource;
import com.antiy.common.utils.LogUtils;
import com.antiy.common.base.QueryCondition;
import com.antiy.common.utils.ParamterExceptionUtils;

import com.cuit.bbs.service.IFavoritesArticleService;
import com.cuit.bbs.entity.FavoritesArticle;
import com.cuit.bbs.entity.vo.request.FavoritesArticleRequest;
import com.cuit.bbs.entity.vo.response.FavoritesArticleResponse;
import com.cuit.bbs.entity.vo.query.FavoritesArticleQuery;


/**
 *
 * @author lc
 * @since 2019-02-28
 */
@Api(value = "FavoritesArticle", description = "喜欢的文章表")
@RestController
@RequestMapping("/v1/bbs/favoritesarticle")
public class FavoritesArticleController {
    private static final Logger logger = LogUtils.get();

    @Resource
    public IFavoritesArticleService iFavoritesArticleService;

    /**
     * 保存
     * @param favoritesArticleRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "favoritesArticle") @RequestBody FavoritesArticleRequest favoritesArticleRequest)throws Exception{
        iFavoritesArticleService.saveFavoritesArticle(favoritesArticleRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     * @param favoritesArticleRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "favoritesArticle")FavoritesArticleRequest favoritesArticleRequest)throws Exception{
        iFavoritesArticleService.updateFavoritesArticle(favoritesArticleRequest);
        return ActionResponse.success();
    }

    /**
     * 批量查询
     * @param favoritesArticleQuery
     * @return actionResponse
     */
    @ApiOperation(value = "批量查询接口", notes = "传入查询条件")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ActionResponse queryList(@ApiParam(value = "favoritesArticle") FavoritesArticleQuery favoritesArticleQuery)throws Exception{
        return ActionResponse.success(iFavoritesArticleService.findPageFavoritesArticle(favoritesArticleQuery));
    }

    /**
     * 通过ID查询
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID查询", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ActionResponse queryById(@ApiParam(value = "favoritesArticle") @PathVariable("id") Integer id)throws Exception{
        ParamterExceptionUtils.isNull(id, "ID不能为空");
        return ActionResponse.success(iFavoritesArticleService.getById(id));
    }

    /**
     * 通过ID删除
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "通过ID删除接口", notes = "主键封装对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ActionResponse.class, responseContainer = "actionResponse"),
    })
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ActionResponse deleteById(@ApiParam(value = "id") @PathVariable("id") Integer id)throws Exception{
        ParamterExceptionUtils.isNull(id, "ID不能为空");
        return ActionResponse.success(iFavoritesArticleService.deleteById(id));
    }
}

