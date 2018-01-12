package com.zhuzb.dao;

import java.util.List;

public abstract interface BaseDao {

    /**
     * 获取实体所有数据
     * @param paramClass
     * @return
     */
    public abstract <T> List<T> getAll(Class<T> paramClass);

    /**
     * 获取实体所有数据带分页
     * @param paramClass
     * @return
     */
    public abstract <T> List<T> getPage(Class<T> paramClass);

    /**
     *保存实体
     *@param paramClass
     */
    public abstract <T> void save(Class<T> paramClass);

    /**
     * 更新实体
     *@param paramClass
     */
    public abstract <T> void update(Class<T> paramClass);

    /**
     * 增加或更新实体
     *@param paramClass
     */
    public abstract <T> void saveOrUpdate(Class<T> paramClass);
}
