package com.chapter14.Exercise3;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedExercise {
    public static void main(String[] args) {
        Collection c = new LinkedList();
        c.add(1);
        c.add(2);
        c.add(3);
        c.remove(2);
        System.out.println(c);
    }
}
