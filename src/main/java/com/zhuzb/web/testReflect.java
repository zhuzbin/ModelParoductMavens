package com.zhuzb.web;

import com.zhuzb.commons.Commons;
import com.zhuzb.entity.FreeMarker;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/8
 * Time：14:35
 */
public class testReflect {

    public static void main(String[] args) throws Exception {
        Class<?> mLocalClass = Class.forName("com.zhuzb.entity.FreeMarker");
        Commons.getReflectAllMethod(mLocalClass);
    }
}
