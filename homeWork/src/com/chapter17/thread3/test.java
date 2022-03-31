package com.chapter17.thread3;

public class test {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("kevin");
        t.start();
        for (int i =0;i<10;i++){
            System.out.println("hi"+i);
            if (i==5){//到五的时候让t插队执行
                System.out.println(t.getName()+"先执行");
                t.join();
                System.out.println("main继续执行");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//子线程输出hello
class T extends Thread{
    @Override
    public void run() {

        for (int i = 0;i<10;i++ ){
            System.out.println("hello"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
