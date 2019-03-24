package com.bysj.dao;


import com.bysj.common.request.ObjectQuery;
import com.bysj.common.response.IBaseDao;
import com.bysj.entity.ApplyPlate;
import com.bysj.entity.vo.response.ApplyPlateResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 版主申请表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-03-12
 */
public interface ApplyPlateDao extends IBaseDao<ApplyPlate> {
    /**
     * 查询所有申请
     * @return
     */
    List<ApplyPlateResponse> findAllApply(ObjectQuery objectQuery);

    /**
     * 查询所有有效申请数量
     * @return
     */
    Integer findAllCount();

    ApplyPlate getInfoByUserIdAndPlateId(@Param("userId") Integer userId, @Param("plateId") Integer plateId);
}
