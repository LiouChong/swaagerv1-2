package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Plater;
import com.bysj.entity.vo.response.PlateNameForIndex;

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
}
