package com.chapter15.GenericExercise2;

public class MyDate implements Comparable<MyDate> {
    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day;
    }


    @Override
    public int compareTo(MyDate o) {
        int temp =  this.year-o.getYear();
        if (temp != 0)
            return temp;
        temp = this.month-o.getMonth();
        if (temp !=0)
            return temp;
        temp =  this.day-o.getDay();
        if (temp !=0)
            return temp;
        return 0;
    }
}
