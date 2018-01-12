package com.zhuzb.web;

import java.math.BigDecimal;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/4
 * Time：15:05
 */
public class Test1 {

    public static void main(String[] args) {
        int money = 1140000;
        double lv = 0.05145/12;
        double l = 0.05145;
        int day = 300;
        double a = money*lv*Math.pow(lv+1,300)/(Math.pow(lv+1,300)-1);
        double a1 =  day*money*lv*Math.pow(lv+1,300)/(Math.pow(lv+1,300)-1)-money;
        double f1 = douFormat(a);//每月还款额
        double f2 = douFormat(a1);//总利息
        double ben = 0;
        for(int i=1;i<=300;i++){
            double a2 = douFormat((1140000*lv-f1)*Math.pow(lv+1,i-1)+f1);//第几个月利息
            double b4 = douFormat(f1-a2);//第几个月本金
            ben = ben+b4;
            System.out.println("第"+i+"月"+a2+"----------->"+b4+"---------->"+(a2+b4));
        }
/*        BigDecimal ben1 = new BigDecimal(ben);
        double ben2 = ben1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//第几个月利息
        System.out.println(ben2);
        double a2 = (1140000*lv-f1)*Math.pow(lv+1,0)+f1;
        BigDecimal b2 = new BigDecimal(a2);
        double f3 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//第几个月利息
        double b4 = f1-f3;
        BigDecimal b3 = new BigDecimal(b4);
        double f4 = b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//第几个月本金
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);*/
        //System.out.println(6300*24);
    }

    //转化
    public static double douFormat(double money){
        BigDecimal bd = new BigDecimal(money);
        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
