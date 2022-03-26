package com.chapter14.Exercise5;


import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    bir b;
    class bir{
        int year;
        int month;
        int day;

        public bir(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            bir bir = (bir) o;
            return year == bir.year &&
                    month == bir.month &&
                    day == bir.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }
    }
    public void setBir(int year,int month,int day){
        b=new bir(year,month,day);
    }
    public Employee(String name, double salary,int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        setBir( year,month,day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public bir getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name) &&
                b.equals(employee.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, b);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", b=" + b +
                '}';
    }
}
