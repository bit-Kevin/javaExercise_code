package com.chapter15.GenericExercise2;

public class employee {
    private  String name;
    private double salary;
    private MyDate dir;

    public employee(String name, double salary, MyDate dir) {
        this.name = name;
        this.salary = salary;
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return
                "\nname='" + name + '\'' +
                ", salary=" + salary +
                ", dir=" + dir;
    }
}
