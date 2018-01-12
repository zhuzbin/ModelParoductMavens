package com.zhuzb.dao.impl;

import com.zhuzb.dao.BaseDao;
import com.zhuzb.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class BaseDaoImpl implements BaseDao {
    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public <T> List<T> getPage(Class<T> paramClass) {
        return null;
    }

    //获取session
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    //分页查询
    public List<Object> getListPage(Object object, Pager pager){
        Criteria criteria = getSession().createCriteria(object.getClass());
        List<Object> lists = criteria.list();
        return lists;
    }

    @Override
    public <T> void save(Class<T> paramClass) {
        getSession().save(paramClass);
    }

    @Override
    public <T> void saveOrUpdate(Class<T> paramClass) {
        getSession().saveOrUpdate(paramClass);
    }

    @Override
    public <T> void update(Class<T> paramClass) {
        getSession().update(paramClass);
    }

    @Override
    public <T> List<T> getAll(Class<T> paramClass) {
        Criteria criteria = getSession().createCriteria(paramClass);
        List<T> lists = criteria.list();
        return lists;
    }

}
