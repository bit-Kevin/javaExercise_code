package com.SeatWork.Exercise1;

import java.util.ArrayList;

public class Exercise2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();//用来存放学生对象的集合
        students.add(new Student(001,"微明","男",15,92));
        students.add(new Student(002,"小明","男",16,91));
        students.add(new Student(003,"中明","男",17,90));
        students.add(new Student(004,"大明","男",18,89));
        students.add(new Student(005,"超大明","男",19,88));
        //输出学生全部信息，并计算平均分
        double sum = 0;
        for (Student student :students ) {
            System.out.println(student);
            //累加成绩
            sum += student.getJava();
        }
        //输出平均分
        System.out.println( "java平均分为："+sum / students.size());
    }

}
class Student{
    private int No;
    private String name;
    private String sex;
    private int age;
    private double java;

    public Student(int no, String name, String sex, int age, double java) {
        No = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.java = java;
    }

    public int getNo() {
        return No;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public double getJava() {
        return java;
    }

    @Override
    public String toString() {
        return
                "学号=" + No +
                ", 姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 年龄=" + age +
                ", java分数=" + java ;
    }
}
