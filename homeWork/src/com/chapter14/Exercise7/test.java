package com.chapter14.Exercise7;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"马超");
        map.put(2,"关羽");
        map.put(3,"超云");
        map.put(4,"刘备");
        map.put(5,"张飞");
        System.out.println("第1种方法======================");
        Set keys = map.keySet();//通过keySet把map编译类型转为set。然后调用set接口特有的迭代器。
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();//通过迭代器获取key值
            Object value = map.get(key);//因为key值是Object类可以直接作为实参传入map编译类型的方法
            System.out.println("迭代器"+key+"-"+value);
        }
        for (Object key : keys ) {
            System.out.println("for:"+key+"-"+map.get(key));
        }
        System.out.println("第2种方法======================");
        Set obj = map.entrySet();//entrySet实现双方的接口可以互相转型
        for (Object entry : obj) {
            Map.Entry e = (Map.Entry) entry;//obj向下转型到entry（entry里面有获取getKey和getValue方法）
            Object key = e.getKey();
            Object value = e.getValue();
            System.out.println("for:"+key+"-"+value);
        }

        Iterator iterator1 = obj.iterator();
        while (iterator1.hasNext()) {
            Object entry =  iterator1.next();
            Map.Entry e = (Map.Entry) entry;
            Object key = e.getKey();
            Object value = e.getValue();
            System.out.println(key+"-"+value);

        }
        System.out.println("第3种方法======================");
        Collection values = map.values();
        for (Object value : values) {
            System.out.println("for"+value);
        }
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println("迭代器"+value);
        }
        System.out.println(map);

    }
}
