package com.chapter14.Exercise2List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List col= new ArrayList();
        col.add("hello1");
        col.add("hello2");
        col.add("hello3");
        col.add("hello4");
        col.add("hello5");
        col.add("hello6");
        col.add("hello7");
        col.add("hello8");
        col.add("hello9");
        col.add("hello10");
        col.add(2,"hsp");
        System.out.println( col.get(5));
        col.remove(6);
        col.set(7,"set");
        Iterator i = col.iterator();//为了不改变原有的数据
        while(i.hasNext()){
            Object obj = i.next();
            System.out.println(obj);
        }
    }
}
