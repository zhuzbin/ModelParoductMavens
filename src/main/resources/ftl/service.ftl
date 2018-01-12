<#--modelName、实体名称
author、作者
date、创建时间-->
/*
* 文 件 名: ${modelName}Service.java
* 版 权: zhongzairong Co., Ltd. Copyright, All rights reserved
* 描 述: <描述>
    * 创 建 人: ${author}
    * 创建时间: ${date}
    */
    package com.carloan.basis.service;

    import java.io.Serializable;
    import java.util.Collection;
    import java.util.List;

    import com.carloan.hibernate.query.QueryWrapper;
    import com.carloan.hibernate.query.filter.FilterWrapper;
    import com.carloan.hibernate.query.sort.SortWrapper;

    import com.carloan.basis.model.${modelName};

    /**
    * <${modelName} service接口><br/>
    * <功能详细描述>
        *
        * @author ${modelName}
        * @version [v1.0, ${date}]
        */
        public interface ${modelName}Service{

            /**
            * 获得所有实体
            *
            * @param <T>
            * @param clazz
            * @return
            */
            public List<${modelName}> getAll();

            /**
            * 通过ID得实体
            *
            * @param <T>
            * @param clazz
            * @param id
            * @return
            */
            public ${modelName} getById(Serializable id);

            /**
            * 持久化实体
            *
            * @param <T>
            * @param o
            * @return
            */
            public Serializable doSave(${modelName} o);

            /**
            * 删除实体
            *
            * @param <T>
            * @param clazz
            * @param id
            */
            public void doDelete(Serializable id);

            /**
            * 删除实体
            *
            * @param <T>
            * @param clazz
            * @param id
            */
            public void doDelete(FilterWrapper filter);

            /**
            * 删除实体
            *
            * @param <T>
            * @param clazz
            * @param id
            */
            public void doDelete(${modelName} o);

            /**
            * 更新实体
            *
            * @param
            * @param o
            */
            public void doUpdate(${modelName} o);

            /**
            * 合并实体
            *
            * @param
            * @param o
            * @return
            */
            public ${modelName} doMerge(${modelName} o);

            /**
            * 得实体总数
            *
            * @param
            * @param modelClass
            * @return
            */
            public int getCount();

            /**
            * 得符合过滤条件的实体总数
            *
            * @param
            * @param modelClass
            * @param filter
            * @return
            */
            public int getCountByFilter(FilterWrapper filter);

            /**
            * 得分页的实体列表
            *
            * @param
            * @param modelClass
            * @param rowStart
            * @param offset
            * @return
            */
            public List<${modelName}> getEntities(int rowStart, int offset);

            /**
            * 得符合过滤条件且分页的实体列表
            *
            * @param
            * @param modelClass
            * @param filter
            * @param rowStart
            * @param offset
            * @return
            */
            public List<${modelName}> getEntitiesByFilter(FilterWrapper filter);

            /**
            * 得符合过滤条件且分页的实体列表
            *
            * @param
            * @param modelClass
            * @param filter
            * @param rowStart
            * @param offset
            * @return
            */
            public List<${modelName}> getEntitiesByFilter(FilterWrapper filter, int rowStart, int offset);

            /**
            * 得符合过滤条件且分页的实体列表,并排序
            *
            * @param
            * @param modelClass
            * @param filter
            * @param sort
            * @param rowStart
            * @param offset
            * @return
            */
            public List<${modelName}> getEntitiesByFilterAndSort(FilterWrapper filter, SortWrapper sort, int rowStart,int offset);

            /**
            * 得符合过滤条件且分页的实体列表,并排序
            *
            * @param
            * @param modelClass
            * @param filter
            * @param sort
            * @return
            */
            public List<${modelName}> getEntitiesByFilterAndSort(FilterWrapper filter, SortWrapper sort);

            /**
            * 按QueryWrapper得实体列表
            *
            * @param
            * @param modelClass
            * @param qw
            * @return
            */
            public List<${modelName}> getEntitiesByQuery(QueryWrapper qw);

            /**
            * 批量持久化实体
            *
            * @param
            * @param entity
            */
            public void doBatchSave(${modelName}... entity);

            /**
            * 批量持久化实体
            *
            * @param
            * @param entity
            */
            public void doBatchSave(Collection<${modelName}> entitys);

            /**
            * 批量更新实体
            *
            * @param
            * @param entity
            */
            public void doBatchUpdate(${modelName}... entity);

            /**
            * 批量更新实体
            *
            * @param entitys
            */
            public void doBatchUpdate(Collection<${modelName}> entitys);

            /**
            * 批量合并
            *
            * @param entitys
            */
            public void doBatchMerge(Collection<${modelName}> entitys);


            /**
            * 批量合并
            *
            * @param entity
            */
            public void doBatchMerge(${modelName}... entity);

            /**
            * 批量删除实体
            *
            * @param
            * @param clazz
            * @param id
            */
            public void doBatchDelete(Serializable... id);

            /**
            * 批量删除实体
            *
            * @param
            * @param clazz
            * @param id
            */
            public void doBatchDelete(${modelName}... entity);

            /**
            * 批量删除实体
            *
            * @param
            * @param clazz
            * @param id
            */
            public void doBatchDelete(Collection<${modelName}> entitys);

    }

