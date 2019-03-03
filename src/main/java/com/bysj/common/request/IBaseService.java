package com.bysj.common.request;

import com.bysj.common.response.PageResult;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface IBaseService<T> {
    // 保存
    Integer save(T entity) throws Exception;

    // 修改
    Integer update(T entity) throws Exception;

    // 删除
    Integer deleteById(Serializable id) throws Exception;

    // 查询（ID）
    T getById(Serializable id) throws Exception;

    // 查询（where）
    List<T> getByWhere(HashMap<String, Object> params) throws Exception;

    // 查询（All）
    List<T> getAll() throws Exception;

    // 查询(分页 查询)
    PageResult<T> findPage(ObjectQuery queryObject) throws Exception;

    // 查询总条数
    Integer findCount(ObjectQuery objectQuery) throws Exception;
}

