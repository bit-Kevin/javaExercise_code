package com.chapter01.exercise4;

public class  student extends person {
    private int studentNum;
    private String like;
    public String study(){
        return "\n我承诺，我会认真学习";
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String play() {
        return super.play()+like;
    }

    @Override
    public String toString() {
        return "student{" +
                "studentNum=" + studentNum +
                ", like='" + like + '\'' +
                '}'+super.toString();
    }

    public student(String name, int age, String sex, int studentNum, String like) {
        super(name, age, sex);
        this.studentNum = studentNum;
        this.like = like;
    }
}
