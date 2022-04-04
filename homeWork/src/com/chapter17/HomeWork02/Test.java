package com.chapter17.HomeWork02;

public class Test {
    public static int money =10000;
    public static void main(String[] args) {
        A a1 = new A();
        Thread thread2 = new Thread(a1);
        Thread thread1 = new Thread(a1);
        thread1.start();
        thread2.start();

    }
}
class A implements Runnable {
    @Override
    public  void run() {//取钱程序
        while (true){
            if (Test.money<=0){
                System.out.println("线程结束");
                break;}
            synchronized (this){ Test.money -=1000;
                System.out.println(Thread.currentThread().getName()+ "取出1000");
                System.out.println("剩下："+Test.money);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
