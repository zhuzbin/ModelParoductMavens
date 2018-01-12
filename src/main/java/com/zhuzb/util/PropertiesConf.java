package com.zhuzb.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

@Component("configProperty")
public class PropertiesConf {

    private static String paroductName;     //项目名称

    public static String getParoductName() {
        return paroductName;
    }
    @Value("#{setting[productName]}")
    public void setParoductName(String paroductName) {
        PropertiesConf.paroductName = paroductName;
    }

    public static String getPro(String proName){
        Properties pros = new Properties();
        Resource resource = new ClassPathResource("properitons/conf.properties");
        if (resource.isReadable()) {
            try {
                InputStream is = resource.getInputStream();
                pros.load(is);
                return pros.getProperty(proName).trim();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

}
