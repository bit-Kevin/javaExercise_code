package com.chapter15.GenericExercise;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashSet<student> set = new HashSet<student>();//创建一个只能容纳student类型的集合
        set.add(new student("A",18));
        set.add(new student("B",20));
        set.add(new student("C",19));
        Iterator<student> iterator = set.iterator();
        while (iterator.hasNext()) {
            student next =  iterator.next();
            System.out.println(next);
        }
        HashMap<Integer,student>  map = new HashMap<Integer, student>();
        map.put(1,new student("A",18));
        map.put(2,new student("B",18));
        map.put(3,new student("C",18));
        Set<Map.Entry<Integer, student>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, student>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry next =  iterator1.next();
            System.out.println(next.getKey()+"-"+next.getValue());
        }


    }
}
class student{
    String name;
    int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}