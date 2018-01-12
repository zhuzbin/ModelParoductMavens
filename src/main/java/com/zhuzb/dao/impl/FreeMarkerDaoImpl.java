package com.zhuzb.dao.impl;

import com.zhuzb.dao.FreeMarkerDao;
import com.zhuzb.entity.FreeMarker;
import com.zhuzb.util.PropertiesConf;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class FreeMarkerDaoImpl extends BaseDaoImpl implements FreeMarkerDao {

    @Override
    public List<Map<String,Object>> freeList(String tableName) {
        String databaseName = PropertiesConf.getPro("databaseName");
        StringBuffer sb = new StringBuffer("SELECT cl.COLUMN_NAME AS columnName,cl.DATA_TYPE AS dataType,cl.COLUMN_COMMENT AS columnComment FROM `COLUMNS` AS cl WHERE cl.TABLE_SCHEMA = ? AND cl.TABLE_NAME = ?");
        SQLQuery query = getSession().createSQLQuery(sb.toString());
        query.setString(0,databaseName).setString(1,tableName);
        //把返回集合变成map
        query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List lists = query.list();
        List<Map<String,Object>> arry = new ArrayList<Map<String,Object>>();
        if(lists.size()>0){
            for(int i=0;i<lists.size();i++){
                Map m = (Map)lists.get(i);
                arry.add(m);
            }
        }
        return arry;
    }

    @Override
    public List<Map<String,Object>> freeTableList(int first,int num) {
        //获取配置文件数据库名称
        String databaseName = PropertiesConf.getPro("databaseName");
        StringBuffer sb = new StringBuffer("SELECT c.TABLE_NAME AS tableName FROM `COLUMNS` AS c WHERE c.TABLE_SCHEMA = ? GROUP BY TABLE_NAME");
        SQLQuery query = getSession().createSQLQuery(sb.toString());
        query.setString(0,databaseName).setFirstResult(first).setMaxResults(num);
        //把返回集合变成map
        query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List lists = query.list();
        List<Map<String,Object>> arry = new ArrayList<Map<String,Object>>();
        if(lists.size()>0){
            for(int i=0;i<lists.size();i++){
                Map m = (Map)lists.get(i);
                arry.add(m);
            }
        }
        return arry;
    }

    @Override
    public Integer freeTableCount() {
        String databaseName = PropertiesConf.getPro("databaseName");
        StringBuffer sb = new StringBuffer("SELECT c.TABLE_NAME AS tableName FROM `COLUMNS` AS c WHERE c.TABLE_SCHEMA = ? GROUP BY TABLE_NAME");
        SQLQuery query = getSession().createSQLQuery(sb.toString());
        query.setString(0,databaseName);
        List lists = query.list();
        List<Map<String,Object>> arry = new ArrayList<Map<String,Object>>();
        Integer retInt = 0;
        if(lists.size()>0){
            retInt = lists.size();
        }
        return retInt;
    }
}
