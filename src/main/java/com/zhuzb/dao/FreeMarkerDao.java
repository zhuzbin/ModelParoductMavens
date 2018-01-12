package com.zhuzb.dao;

import com.zhuzb.entity.FreeMarker;

import java.util.List;
import java.util.Map;

public interface FreeMarkerDao {

    public List<Map<String,Object>> freeList(String tableName);

    //获取所有的表
    public List freeTableList(int first,int num);

    //获取所有表集合
    public Integer freeTableCount();
}
