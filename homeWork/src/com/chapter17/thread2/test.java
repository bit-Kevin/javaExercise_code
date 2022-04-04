package com.chapter17.thread2;

public class test {
    public static void main(String[] args) {
        T2 t1 = new T2();
        T2 t2 = new T2();
        T2 t3 = new T2();
        Thread thread1 = new Thread(t1);
        System.out.println(thread1.getName());
        Thread thread2 = new Thread(t1);
        System.out.println(thread2.getName());
        Thread thread3 = new Thread(t1);
        thread1.setName("o3");
//        Thread thread2 = new Thread(t2);
//        Thread thread3 = new Thread(t3);
//        thread1.start();
//        thread2.start();
        thread1.start();
        thread3.start();
        thread2.start();
    }
}
class T1 implements Runnable{
    public static Object o1 = new Object();
    public static Object o2 =new Object();
    boolean flag;

    public T1(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run(){
        int count1 = 0;
       if (flag){
           synchronized (o1){
               while (true){
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("t1 "+count1);
                   count1 ++;
                   if (count1==20)
                       break;
               }
           }
       }else {
           synchronized (o2){
               while (true){
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("t2 "+count1);
                   count1 ++;
                   if (count1==20)
                       break;
               }
           }
       }
    }




}

class T2 implements Runnable{
    public static int count2 = 100;

    @Override
    public synchronized void run(){

        while (true){
            if (count2<=0){
                System.out.println("票已售完");
                break;}
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-1  票剩"+ --count2);


        }
    }
}
