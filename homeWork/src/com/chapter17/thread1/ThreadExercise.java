package com.chapter17.thread1;

public class ThreadExercise {
    public static void main(String[] args) {
        cat c1 = new cat();
        c1.start();
    }
}
//定义自己的线程任务
class cat extends Thread{
    @Override
    public void run(){
        int count = 0;
        while (true){
            System.out.println("小猫喵喵叫");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
            if (count==9)
                break;
        }
    }
}
