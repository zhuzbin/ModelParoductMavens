package com.zhuzb.commons;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * Desc：获取类中所有属性
 * User：ZhuZhiBin
 * Date：2018/1/8
 * Time：14:30
 */
public class Commons  {
    public static void testReflect(Object model) throws Exception{
        Method c = model.getClass().getMethod("getTableSchema");
        String a =  (String) c.invoke(model);
        System.out.println(a);
        Field[] field = model.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组

        for(int j=0 ; j<field.length ; j++){     //遍历所有属性

            String name = field[j].getName();    //获取属性的名字

            System.out.println("attribute name:"+name);
            name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString();    //获取属性的类型

/*            if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
                Method m = model.getClass().getMethod("get"+name);
                String value = (String) m.invoke(model);    //调用getter方法获取属性值
                if(value != null){
                    System.out.println("attribute value:"+value);
                }
            }*/
/*            if(type.equals("class java.lang.Integer")){
                Method m = model.getClass().getMethod("get"+name);
                Integer value = (Integer) m.invoke(model);
                if(value != null){
                    System.out.println("attribute value:"+value);
                }
            }
            if(type.equals("class java.lang.Short")){
                Method m = model.getClass().getMethod("get"+name);
                Short value = (Short) m.invoke(model);
                if(value != null){
                    System.out.println("attribute value:"+value);                    }
            }
            if(type.equals("class java.lang.Double")){
                Method m = model.getClass().getMethod("get"+name);
                Double value = (Double) m.invoke(model);
                if(value != null){
                    System.out.println("attribute value:"+value);
                }
            }
            if(type.equals("class java.lang.Boolean")){
                Method m = model.getClass().getMethod("get"+name);
                Boolean value = (Boolean) m.invoke(model);
                if(value != null){
                    System.out.println("attribute value:"+value);
                }
            }
            if(type.equals("class java.util.Date")){
                Method m = model.getClass().getMethod("get"+name);
                Date value = (Date) m.invoke(model);
                if(value != null){
                    System.out.println("attribute value:"+value.toLocaleString());
                }
            }*/
        }
    }
    public static void getReflectAllMethodcc(Class<?> mLocalClass){

    }

    public static void getReflectAllMethod(Class<?> mLocalClass){

        Class<?> c;
        c = mLocalClass;
        try {
            do{
                Method m[] = c.getDeclaredMethods(); // 取得全部的方法
                for (int i = 0; i < m.length; i++) {
                    String mod = Modifier.toString(m[i].getModifiers()); // 取得访问权限
                    String metName = m[i].getName(); // 取得方法名称
                    Class<?> ret = m[i].getReturnType();// 取得返回值类型
                    Class<?> param[] = m[i].getParameterTypes(); // 得到全部的参数类型
                    Class<?> exc[] = m[i].getExceptionTypes(); // 得到全部的异常
                    System.out.print(mod + " ");//输出每一方法的访问权限
                    System.out.print(ret + " ");//输出每一方法的返回值类型
                    System.out.print(metName + " (");//输出每一方法的名字
                    for (int x = 0; x < param.length; x++) {//循环输出每一方法的参数的类型
                        System.out.print(param[x] + "arg-" + x);
                        if (x < param.length - 1) {
                            System.out.print(",");
                        }
                    }
                    System.out.print(") ");
                    if (exc.length > 0) {// 有异常抛出
                        System.out.print("throws ");
                        for (int x = 0; x < exc.length; x++) {//循环输出每一方法所抛出的异常名字
                            System.out.print(exc[x].getName());
                            if (x < param.length - 1) {
                                System.out.print(",");
                            }
                        }
                    }
                    System.out.println();
                }
                c=c.getSuperclass();
                break;
            }while(c!=null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
