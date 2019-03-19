package com.bysj.dao;


import com.bysj.common.response.IBaseDao;
import com.bysj.entity.Askhelp;
import com.bysj.entity.vo.request.AskhelpRequest;

/**
 * <p>
 * 求问表 Mapper 接口
 * </p>
 *
 * @author lc
 * @since 2019-02-28
 */
public interface AskhelpDao extends IBaseDao<Askhelp> {
    Integer insertBySelf(AskhelpRequest request);
}
