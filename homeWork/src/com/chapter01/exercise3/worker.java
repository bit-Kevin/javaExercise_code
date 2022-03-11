package com.chapter01.exercise3;

public class worker extends employee {
    double wageLevel;

    public worker(String name, double wage, double workingDays, double wageLevel) {
        super(name, wage, workingDays);
        this.wageLevel = wageLevel;
    }

    @Override
    public void print() {
        System.out.println("name:"+name+"\twage:"+wage+"\tworkingDays:"+workingDays+"\ttotal:"+wage*workingDays*wageLevel);
    }
}
