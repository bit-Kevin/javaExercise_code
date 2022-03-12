package com.chapter01.bank;

public class demo {
    public static void main(String[] args) {
        checkingAccount checkingAccount = new checkingAccount(1000.0, 1);
        checkingAccount.deposit(100.);
        checkingAccount.deposit(100.);
        checkingAccount.deposit(100.);
        checkingAccount.deposit(100.);
        checkingAccount.withdraw(200.);
        System.out.println(checkingAccount.getBalance());
        checkingAccount.MonthlyInterest();//假设月底了，计算利率并加入到存款里面去。重置免息次数
        System.out.println("计算利率后存款："+checkingAccount.getBalance());
        checkingAccount.deposit(100.);
        System.out.println(checkingAccount.getBalance());
    }
}
