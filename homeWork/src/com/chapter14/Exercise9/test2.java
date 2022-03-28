package com.chapter14.Exercise9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);
        map.put("jack",2600);
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            String key =(String) entry.getKey();
            int value =(int) entry.getValue();
            map.put(key,value+100);
        }
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println("员工:"+entry.getKey()+"\n工资："+entry.getValue());
        }



    }
}
