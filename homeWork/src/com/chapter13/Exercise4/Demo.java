package com.chapter13.Exercise4;

public class Demo {
    public static void main(String[] args) {
        String s = new String("Han Shun Ping");
        print(s);

    }
    public static void print(String s){
        if (s==null){
            System.out.println("输入的数为空" );
            return;
        }
        String[] arr= s.split(" ");
        if (arr.length!=3){
            System.out.println("数据不对");
        }
        String format=  String.format("%s,%s.%s",arr[2],arr[0],arr[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
