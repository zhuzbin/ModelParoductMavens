package com.zhuzb.service;

import com.zhuzb.entity.FreeMarker;

import java.util.List;

public interface FreeMarkerService {

    public List freeList(String tableName);

    public List freeTableList(int first,int num);

    public Integer freeTableCount();
}
