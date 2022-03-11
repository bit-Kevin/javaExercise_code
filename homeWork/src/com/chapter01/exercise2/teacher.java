package com.chapter01.exercise2;

public class teacher {
    String name ;
    int age ;
    String post;
    double salary;
    public void introduce(){
        System.out.println("name:"+name+"\tage:"+age+"\tpost:"+post+"\tsalary:"+salary);
    }

    public teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }
}
