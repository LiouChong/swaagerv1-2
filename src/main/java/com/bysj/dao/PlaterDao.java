package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Plater;
import com.bysj.entity.vo.response.PlateNameForIndex;
import com.bysj.entity.vo.response.PlaterForUserInfoResponse;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 板块表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface PlaterDao extends IBaseDao<Plater> {
    /**
     * 查询所有板块名字
     * @return
     */
    List<PlateNameForIndex> findAllPlateName();

    /**
     * 根据用户id查询其管理的板块
     * @param userId
     * @return
     */
    List<String> findPlateNameByUserId(@Param("userId") Integer userId);

    /**
     * 根据板块id查询版主名称
     * @param plateId
     * @return
     */
    PlaterForUserInfoResponse getOwnerById(Integer plateId);

    /**
     * 根据板块名设置版主
     * @param params
     * @return
     */
    Integer setPlaterByplateName(HashMap<String, Object> params);


    Integer takeOffPlater(@Param("plateId") Integer plateId,
                          @Param("gmtModify") Date gmtCreate,
                          @Param("userModify") Integer userId);

}
