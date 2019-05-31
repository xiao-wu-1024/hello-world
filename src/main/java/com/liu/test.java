package com.liu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String []args){
        for (int i=0;i<100;i++){
            System.out.println(0.08f+0.01f);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date=new Date();
        System.out.println("时间："+df.format(date));
    }
}
