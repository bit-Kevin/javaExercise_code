package com.chapter17.thread2;

public class test {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
class T1 implements Runnable{
    @Override
    public void run(){
         int count1 = 0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1"+count1);
            count1 ++;
            if (count1==60)
                break;
        }
    }
}

class T2 implements Runnable{
    @Override
    public void run(){
         int count2 = 0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2"+count2);
            count2 ++;
            if (count2==60)
                break;
        }
    }
}
