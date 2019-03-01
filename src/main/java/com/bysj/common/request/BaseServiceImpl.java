package com.bysj.common.request;

import com.bysj.common.response.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseServiceImpl<T> implements IBaseService<T> {

        @Autowired
        private IBaseDao<T> baseDao;

        /**
         *
         * 方法名：save
         * @return
         * @param entity 返回类型：void 说明：保存 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
         */
        @Override
        public Integer save(T entity) throws Exception {
            return baseDao.insert(entity);
        }

        /**
         *
         * 方法名：update
         * @return
         * @param entity 返回类型：void 说明：修改 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
         */
        @Override
        public Integer update(T entity) throws Exception {
            return baseDao.update(entity);
        }

        /**
         *
         * 方法名：deleteById
         * @return
         * @param id 返回类型：void 说明：删除 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
         */
        @Override
        public Integer deleteById(Serializable id) throws Exception {
            return baseDao.deleteById(id);
        }

        /**
         *
         * 方法名：getById
         * @return
         * @param id 返回类型：T 说明：查询（ID） 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
         */
        @Override
        public T getById(Serializable id) throws Exception {
            return baseDao.getById(id);
        }

        /**
         *
         * 方法名：getByWhere
         * @return
         * @param params 返回类型：List<T> 说明：查询（Where） 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
         */
        @Override
        public List<T> getByWhere(HashMap<String, Object> params) throws Exception {
            return baseDao.getByWhere(params);
        }

        /**
         *
         * 方法名：getAll
         * @return 返回类型：List<T> 说明：查询（ALL） 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
         */
        @Override
        public List<T> getAll() throws Exception {
            return baseDao.getAll();
        }

        /**
         *
         * 方法名：getPageList
         * @param queryObject 查询对象
         * @return 返回类型：PageSupport<T> 说明：分页查询\一般查询（当queryObject为null,则作页面查询，就是一般结果集） 创建人： 创建日期：2016-5-24上午10:48:53 修改人：
         *         修改日期：
         */
        @Override
        public final PageResult<T> findPage(ObjectQuery queryObject) throws Exception {
            PageResult<T> pageResult = new PageResult<T>();
            pageResult.setCurrentPage(queryObject.getCurrentPage());
            pageResult.setPageSize(queryObject.getPageSize());

            // 1)分页查询
            if (queryObject != null) {
                Integer totalRecord = this.findCount(queryObject);
                if (totalRecord == null || totalRecord.intValue() <= 0) {
                    pageResult.setItems(new ArrayList<T>());
                    return pageResult;
                }
                pageResult.setTotalRecords(totalRecord);
            }

            // 2)一般查询（没有分页）
            List<T> resultList = this.findQuery(queryObject);
            pageResult.setCurrentPage(queryObject.getCurrentPage());// 当前页
            pageResult.setItems(resultList);
            return pageResult;
        }

        /**
         *
         * 方法名：findQuery
         * @param objectQuery
         * @return
         * @throws Exception 返回类型：List<T> 说明：查询结果集 （分页查询基本实现，若自定义，@Override即可） 创建人: 创建日期：2016-7-13下午3:01:35 修改人： 修改日期：
         */
        public List<T> findQuery(ObjectQuery objectQuery) throws Exception {
            return baseDao.findQuery(objectQuery);
        };

        /**
         *
         * 方法名：findCount
         * @param objectQuery
         * @return
         * @throws Exception 返回类型：Integer 说明：查询总条数 （分页查询基本实现，若自定义，@Override即可） 创建人： 创建日期：2016-7-13下午3:02:31 修改人： 修改日期：
         */
        @Override
        public Integer findCount(ObjectQuery objectQuery) throws Exception {
            return baseDao.findCount(objectQuery);
        }

    }

