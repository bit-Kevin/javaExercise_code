package com.chapter14;

import java.util.HashSet;

public class Exercise4 {
   static C s1 = new C("ykw");
   static C s2= new C("ykw");
    public static void main(String[] args) {
        HashSet H = new HashSet();
        H.add("C语言");
        H.add("java");
        H.add("C语言");
        System.out.println(H);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.key==s2.key);
    }
}
class C{
    String key ;

    public C(String key) {
        this.key = key;
    }
}
