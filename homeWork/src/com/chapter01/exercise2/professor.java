package com.chapter01.exercise2;

public class professor extends teacher{
    double level;

    public professor(String name, int age, String post, double salary, double level) {
        super(name, age, post, salary);
        this.level = level;
    }

    @Override
    public void introduce() {
        System.out.println("name:"+name+"\tage:"+age+"\tpost:"+post+"\tsalary:"+salary*level);
    }
}
