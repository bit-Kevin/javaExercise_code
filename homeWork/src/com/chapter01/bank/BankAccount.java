package com.chapter01.bank;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;//初始化余额
    }
    public void deposit(double amount){
        //核心存款方法，方便调用
        balance +=amount;
    }
    public void withdraw(double amount){
        //核心取款方法
        balance -=amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
