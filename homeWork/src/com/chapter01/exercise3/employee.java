package com.chapter01.exercise3;

public class employee {
    String name;
    double wage;
    double workingDays;
    public void print(){
        System.out.println("name:"+name+"\twage:"+wage+"\tworkingDays:"+workingDays+"\ttotal:"+wage*workingDays);
    }

    public employee(String name, double wage, double workingDays) {
        this.name = name;
        this.wage = wage;
        this.workingDays = workingDays;
    }
}
