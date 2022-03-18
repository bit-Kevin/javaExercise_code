package com.chapter10.homeWork1;

public class frock {
    private static int currentNum = 100000;
    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }
    private int serialNumber;

    public frock() {
        this.serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
