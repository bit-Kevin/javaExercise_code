package com.chapter01.bank;

public class SavingAccount extends BankAccount{
    private double rate;//存款利率


    public SavingAccount(Double balance, double rate) {
        super(balance);
        this.rate = rate;
    }

    //每月存款利率存入账户
    public double rate(){
        double temp;
        System.out.println(getBalance());
        temp=getBalance()+getBalance()*rate;
        System.out.println(temp);
        return temp;

    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
