package com.zhuzb.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HibernateFreeMarker {

    public Template getTemplate(String name){
        try {
            Configuration cfs = new Configuration();
            cfs.setClassForTemplateLoading(this.getClass(), "/ftl");
            Template tl = cfs.getTemplate(name,"UTF-8");
            return tl;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }


    public void print(String name, Map<String,Object> root, String fileName){
        OutputStreamWriter out = null;
        try {
            Template tl = this.getTemplate(name);
            File file = new File("D:\\freeMarker\\ftl\\"+fileName);
            out = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
            //FileWriter fw = new FileWriter(file);
            tl.process(root, out);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(out!=null){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void printList(String name, List list, String fileName){
        OutputStreamWriter out = null;
        try {
            Template tl = this.getTemplate(name);
            File file = new File("D:\\freeMarker\\ftl\\"+fileName);
            out = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
            //FileWriter fw = new FileWriter(file);
            tl.process(list, out);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(out!=null){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
