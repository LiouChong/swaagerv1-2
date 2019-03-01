package com.bysj.common.response;


import com.bysj.common.request.ObjectQuery;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Component
public interface IBaseDao<T> {
    Integer insert(T entity) throws Exception;

    Integer update(T entity) throws Exception;

    Integer deleteById(Serializable id) throws Exception;

    T getById(Serializable id) throws Exception;

    List<T> getByWhere(HashMap<String, Object> params) throws Exception;

    List<T> getAll() throws Exception;

    List<T> findQuery(ObjectQuery objectQuery) throws Exception;

    Integer findCount(ObjectQuery objectQuery) throws Exception;
}

