package com.chapter12;

import java.util.Scanner;

public class exception1 {
    public static void main(String[] args) {
        tools tools = new tools();
        int n=tools.select();
        System.out.println(n);
    }
}

class tools {
    public int select() {
        int n;
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String temp = scanner.next();
            try {
                n = Integer.parseInt(temp);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("请输入整数");
            }

        }
        return n;
    }
}
