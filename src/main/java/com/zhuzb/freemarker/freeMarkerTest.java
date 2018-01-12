package com.zhuzb.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class freeMarkerTest {

    public Template getTemplate(String name){
        try {
            Configuration cfs = new Configuration();
            cfs.setClassForTemplateLoading(this.getClass(), "/ftl");
            Template tl = cfs.getTemplate(name);
            return tl;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public void print(String name,Map<String,Object> root,String fileName){
        try {
            Template tl = this.getTemplate(name);
            File file = new File("D:\\freeMarker\\ftl\\"+fileName);
            FileWriter fw = new FileWriter(file);
            tl.process(root, fw);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printCo(String name,Map<String,Object> root){
        try {
            Template tl = this.getTemplate(name);
            tl.process(root, new PrintWriter(System.out));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        freeMarkerTest test = new freeMarkerTest();
        Map<String,Object> maps = new HashMap<String,Object>();
        maps.put("tableName","aaaaaa_bbbbbb_cccccc");
        test.printCo("entityModel.ftl",maps);
    }
}
