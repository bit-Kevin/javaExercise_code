package com.chapter14.Exercise5;

import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("abc",120,2001,12,12));
        hashSet.add(new Employee("abd",120,2001,12,12));
        hashSet.add(new Employee("abe",120,2001,12,12));
        hashSet.add(new Employee("abc",120,2001,12,12));
        System.out.println(hashSet);
    }
}
