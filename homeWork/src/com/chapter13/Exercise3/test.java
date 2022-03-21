package com.chapter13.Exercise3;

public class test {
    public static void main(String[] args) {
        try {
            Account A1 = new Account("王五", "123456", "12345@qq.com");
            System.out.println(A1.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
