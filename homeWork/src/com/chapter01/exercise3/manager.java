package com.chapter01.exercise3;

public class manager extends employee {
    double wageLevel;

    public manager(String name, double wage, double workingDays, double wageLevel) {
        super(name, wage, workingDays);
        this.wageLevel = wageLevel;
    }

    @Override
    public void print() {
        System.out.println("name:"+name+"\twage:"+wage+"\tworkingDays:"+workingDays+"\ttotal:"+wage*workingDays*wageLevel);
    }
}
