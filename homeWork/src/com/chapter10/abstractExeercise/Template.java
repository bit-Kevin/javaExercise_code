package com.chapter10.abstractExeercise;


abstract public class Template {
    public abstract void job();//抽象方法
    //统计时间的实例方法
    public void caleTimes(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }
}
