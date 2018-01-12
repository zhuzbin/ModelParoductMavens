package com.zhuzb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tree")
public class TreeController {

    @RequestMapping("/indexV1")
    public String indexV1(){
        return "indexV1";
    }

    @RequestMapping("/indexV2")
    public String indexV2(){
        return "indexV2";
    }

    @RequestMapping("/formBasic")
    public String formBasic(){
        return "formBasic";
    }

    @RequestMapping("/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping("/dataTable")
    public String dataTables(){
        return "bootstrapTable";
    }

    @RequestMapping("/dataDetialTable")
    public String dataDetialTable(HttpServletRequest request){
        request.setAttribute("tableName",request.getParameter("tableName"));
        return "bootstrapInput";
    }

    @RequestMapping("/dataDetialController")
    public String dataDetialController(HttpServletRequest request){
        request.setAttribute("tableName",request.getParameter("tableName"));
        return "dataDetialController";
    }


    @RequestMapping("/sessionCheck")
    public String sessionCheck(HttpSession session, HttpServletRequest request, String id, String msg){
        if("a".equals(id)){
            session.setAttribute("msg",msg);
        }else {
            if(session.getAttribute("msg")!=null&&!"".equals(session.getAttribute("msg"))){
                String msgs = session.getAttribute("msg").toString();
                request.setAttribute("msg",msgs);
            }else{
                return "session/error";
            }

        }
        return "session/index";
    }
}
