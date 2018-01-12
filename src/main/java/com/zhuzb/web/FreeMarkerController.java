package com.zhuzb.web;

import com.zhuzb.entity.FreeMarker;
import com.zhuzb.service.FreeMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "freeMarker")
public class FreeMarkerController {
    @Autowired
    private FreeMarkerService freeMarkerService;

    /**
     * 获取所有表的数据
     */
    @RequestMapping(value = "tableList")
    public Map<String,Object> getTableList(HttpServletRequest request){
        Integer first = Integer.valueOf(request.getParameter("offset"));//显示查询条数（不用计算，直接获取）
        Integer num = Integer.valueOf(request.getParameter("limit"));//显示条数
        List<Map<String,Object>> lists = freeMarkerService.freeTableList(first,num);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",freeMarkerService.freeTableCount());
        map.put("rows",lists);
        return map;
    }

    /**
     * 获取表的详情
     */
    @RequestMapping(value = "tableDetailList")
    public Map<String,Object> getTableDetailList(HttpServletRequest request){
        String tableName = request.getParameter("tableName");
        List lists = freeMarkerService.freeList(tableName);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",freeMarkerService.freeTableCount());
        map.put("rows",lists);
        return map;
    }


}
