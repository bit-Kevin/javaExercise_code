package com.chapter10.homeWork3;

public class test {
    public static void main(String[] args) {
        cellphone A = new cellphone();
        A.testWork(new sum() {
            @Override
            public int work(int i,int j) {
                return i+j;
            }
        },10,20);
    }
}
