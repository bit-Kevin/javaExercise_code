package com.chapter10.innerClass;

public class Exercise1 {
    public static void main(String[] args) {
        cellphone cellphone = new cellphone();
        cellphone.alarmclock(new bell() {
            @Override
            public void ring() {
                System.out.println("懒猪该起床了");
            }
        });
        cellphone.alarmclock(new bell() {
            @Override
            public void ring() {
                System.out.println("该上课了");
            }
        });

    }
}

interface bell{
    void ring();
}
class cellphone{
    public void alarmclock(bell b){
        b.ring();
    }
}