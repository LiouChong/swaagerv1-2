package com.bysj.common;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: zhangbing
 * @date: 2018/11/22 14:09
 * @description: 基础转换类
 */
@Component
public class BaseConverter<S, T> {

    /**
     * 单个对象转换
     */
    public T convert(S s, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (Exception e) {
        }
        if (s != null) {
            convert(s, t);
        }
        return t;
    }

    /**
     * list对象转换
     */
    public List<T> convert(List<S> fromList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(fromList)) {
            return new ArrayList<T>();
        }
        List<T> toList = new ArrayList<T>();
        for (S from : fromList) {
            toList.add(convert(from, clazz));
        }
        return toList;
    }

    /**
     * 转换为PageResult
     * @param pageResult
     * @param clazz
     * @return
     */
    public PageResult<T> convert(PageResult<S> pageResult, Class<T> clazz) {
        PageResult<T> result = new PageResult<T>();
        if (pageResult != null && CollectionUtils.isNotEmpty(pageResult.getItems())) {
            BeanUtils.copyProperties(pageResult, result);
            result.setItems(convert(pageResult.getItems(), clazz));
        }
        return result;
    }

    /**
     * 属性拷贝方法，有特殊拷贝需求时覆写此方法
     */
    protected void convert(S s, T t) {
        BeanUtils.copyProperties(s, t);
    }
}
