package com.zhuzb.service.impl;

import com.zhuzb.dao.FreeMarkerDao;
import com.zhuzb.dao.StudentDao;
import com.zhuzb.entity.FreeMarker;
import com.zhuzb.service.FreeMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeMarkerServiceImpl implements FreeMarkerService {
    @Autowired
    private FreeMarkerDao freeMarkerDao;

    @Override
    public List freeTableList(int first,int num) {
        return freeMarkerDao.freeTableList(first,num);
    }

    @Override
    public List freeList(String tableName) {
        return freeMarkerDao.freeList(tableName);
    }

    @Override
    public Integer freeTableCount() {
        return freeMarkerDao.freeTableCount();
    }
}
