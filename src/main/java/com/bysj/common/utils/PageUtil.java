package com.bysj.common.utils;

/**
 * @Author: 刘冲
 * @Description:
 * @Date: 2019/3/3 12:07
 */
public class PageUtil {
    public static Integer getTotalPage(Integer totalRecords, Integer pageSize) {
        return totalRecords % pageSize == 0 ?
                totalRecords / pageSize : (totalRecords / pageSize) + 1;
    }
}
