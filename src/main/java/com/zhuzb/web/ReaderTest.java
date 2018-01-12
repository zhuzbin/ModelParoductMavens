package com.zhuzb.web;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/8
 * Time：16:05
 */
@Controller
public class ReaderTest {

    @RequestMapping("getReader")
    public String getReader(HttpServletRequest request) throws Exception{
        File file = new File("F:\\ModelParoductMavens\\src\\main\\java\\com\\zhuzb\\commons\\Calculation.java");
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        String str = result.toString().replaceAll(" ", "");
        System.out.println();

        //获取类种所有的方法
        Class<?> c = Class.forName("com.zhuzb.commons.Calculation");
        Method m[] = c.getDeclaredMethods(); // 取得全部的方法

        Map<String,Object> map;
        List list = new ArrayList();
        for (int i = 0; i < m.length; i++) {
            map = new HashMap<String,Object>();
            String strs = str;
            System.out.println("第"+(i+1)+"个方法当中代码");
            String metName = m[i].getName(); // 取得方法名称

            int len = strs.indexOf(metName);
            String newStr = strs.substring(len,strs.length());
            newStr = newStr.substring(newStr.indexOf("{")+1,newStr.indexOf("}"));
            String[] strings = newStr.split("\r\n");

            List list1 =  Arrays.asList(strings);
            map.put("name",metName);
            map.put("obj",list1);
            list.add(map);
        }
        request.setAttribute("list",list);
        return "reder";
    }

    @RequestMapping("saveCal")
    @ResponseBody
    public String saveCal(HttpServletRequest request) throws Exception {
        File file = new File("F:\\ModelParoductMavens\\src\\main\\java\\com\\zhuzb\\commons\\Calculation.java");
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        String str = result.toString();
        System.out.println();

        //获取类种所有的方法
        Class<?> c = Class.forName("com.zhuzb.commons.Calculation");
        Method m[] = c.getDeclaredMethods(); // 取得全部的方法

        Map<String,Object> map;
        List list = new ArrayList();
        String name = request.getParameter("name");
        StringBuffer newStrs = new StringBuffer();
        for (int i = 0; i < m.length; i++) {
            map = new HashMap<String,Object>();
            String strs = str;
            //System.out.println("第"+(i+1)+"个方法当中代码");
            String metName = m[i].getName(); // 取得方法名称
            if(metName.equals(name)){
                int len = strs.indexOf(metName+"(");
                String newStr = strs.substring(len,strs.length());
                int lenStart = newStr.indexOf("{");
                int lenEnd = newStr.indexOf("}");
                String newStrStart = str.substring(0,len+lenStart+4);
                String newStrEnd = str.substring(len+lenEnd,str.length());
                //封装数据
                String data = request.getParameter("data");


                JSONArray array = new JSONArray(data);
                for(int j=0;j<array.length();j++){
                    Object obj = array.get(j);
                    newStrs.append(obj.toString()+"\r\n");
                }
                str = newStrStart+newStrs.toString()+newStrEnd;
            }
        }
        System.out.println(str);
        //生成文件
        FileWriter fileWriter =new FileWriter("F:\\ModelParoductMavens\\src\\main\\java\\com\\zhuzb\\commons\\Calculation.java");
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\ModelParoductMavens\\src\\main\\java\\com\\zhuzb\\commons\\Calculation.java"));
        bw.write(str);
        bw.close();

        return "reder";
    }



/*    public static void main(String[] args) throws Exception {
        File file = new File("F:\\ModelParoductMavens\\src\\main\\java\\com\\zhuzb\\commons\\Calculation.java");
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        String str = result.toString().replaceAll(" ", "");
        System.out.println();

        //获取类种所有的方法
        Class<?> c = Class.forName("com.zhuzb.commons.Calculation");
        Method m[] = c.getDeclaredMethods(); // 取得全部的方法

        for (int i = 0; i < m.length; i++) {
            String strs = str;
            System.out.println("第"+(i+1)+"个方法当中代码");
            String metName = m[i].getName(); // 取得方法名称

            int len = strs.indexOf(metName);
            String newStr = strs.substring(len,strs.length());
            newStr = newStr.substring(newStr.indexOf("{")+1,newStr.indexOf("}"));
            String[] strings = newStr.split("\r\n");
*//*            System.out.println(strings.length);
            System.out.println(newStr);*//*
            System.out.println(strings);
            //System.out.println(str.substring(str.indexOf(metName+"{"),str.length()));
            //System.out.println(strs.substring(len,strs.length()).substring(0,strs.substring(len,strs.length()).indexOf("}")));
            //System.out.println(str.substring(0,(str.substring(len,str.length())).indexOf("}")));
        }
    }*/
}

