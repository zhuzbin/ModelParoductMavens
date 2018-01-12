package com.zhuzb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 格式化当前时间
     * @param format 返回格式类型
     * @return 字符串时间
     */
    public static String strNewDate(String format){
        //如何为空返回默认时间格式
        if(format == null){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(new Date());
        return  date;
    }
}
