package com.chapter17.HomeWork01;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}
class A extends Thread{
    //循环打印100以内的随机数
    private boolean  flag = true;//终止条件

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag){
            System.out.println((int) (Math.random()*100+1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class B extends Thread{
    //读取Q终止第一个条件
    Scanner scanner = new Scanner(System.in);
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("请输入一个Q中断随机数输出");
        for (;;){

            if (scanner.next().toUpperCase().charAt(0)=='Q'){
                a.setFlag(false);
                System.out.println("终止A程序指令发出");
                break;
            }
        }
    }
}
