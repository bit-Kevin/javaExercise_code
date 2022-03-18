package com.chapter10.enumExercise;

public class week {

    public static void main(String[] args) {
        weekday[] weekdays = weekday.values();
        for (weekday i : weekdays){
            System.out.println(i.getName());
        }
    }
}

enum weekday {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");
    private String name;

    weekday(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}