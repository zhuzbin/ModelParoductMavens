package com.zhuzb.web;

import com.zhuzb.entity.FreeMarker;
import com.zhuzb.entity.Student;
import com.zhuzb.freemarker.HibernateFreeMarker;
import com.zhuzb.service.FreeMarkerService;
import com.zhuzb.service.StudentService;
import com.zhuzb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private FreeMarkerService freeMarkerService;

    @RequestMapping(value = "stu")
    public String stu(HttpServletRequest request,Student student){
        studentService.saveStu(student);
        return "stu";
    }

    @RequestMapping(value = "modelMarker")
    public String modelMarker(HttpServletRequest request,Student student){
        HibernateFreeMarker free = new HibernateFreeMarker();
        Map<String,Object> maps = new HashMap<String,Object>();
        String modelName = "UserName";
        maps.put("modelName",modelName);
        maps.put("author","zhuzb");
        maps.put("date",DateUtil.strNewDate("yyyy-MM-dd"));
        free.print("service1.ftl",maps,modelName+"Service.java");
        return "modelMarker";
    }

    @RequestMapping(value = "getStuList")
    @ResponseBody
    public Map<String,Object> getStuList(HttpServletRequest request){
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }
        Map<String,Object> map = new HashMap<String,Object>();
        List<Student> lists = studentService.getList();
        map.put("draw",Integer.valueOf(request.getParameter("draw")));
        map.put("recordsTotal",lists.size());
        map.put("recordsFiltered",lists.size());
        map.put("data",lists);
        return map;
    }

    @RequestMapping(value = "freemarker")
    public String freemarker(HttpServletRequest request,Student student){
        HibernateFreeMarker free = new HibernateFreeMarker();
        String tableName = "student";
        List<FreeMarker> lists = freeMarkerService.freeList(tableName);
        Map<String,Object> maps = new HashMap<String,Object>();
        maps.put("student",lists);
        maps.put("tableName",tableName);
        free.print("entityModel.ftl",maps,"Student.java");
        free.print("MappingModel.ftl",maps,"Student.hbm.xml");
        return "stu";
    }

}
