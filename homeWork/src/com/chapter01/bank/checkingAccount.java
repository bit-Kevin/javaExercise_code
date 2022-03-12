package com.chapter01.bank;

public class checkingAccount extends BankAccount{
    private double bankCharge;//手续费

    public int count=3;//每月免手续费初始次数
    //每月初始化手续费免费次数
    public void MonthlyInterest(){
        SavingAccount savingAccount = new SavingAccount(getBalance(), 0.1);
        setBalance(savingAccount.rate());//调用SavingAccount计算每月利率
        count =3;//把免息次数重置为3
    }
    public checkingAccount(Double balance, double bankCharge) {
        super(balance);//建立新账户初始化余额
        this.bankCharge = bankCharge;//初始化手续费
    }

    @Override
    public void deposit(double amount) {
        //判断是否有免息次数
        if (count>0){
            super.deposit(amount);
            count--;
        }else {
            super.deposit(amount-bankCharge);
        }

    }


    @Override
    public void withdraw(double amount) {
        //判断是否有免息次数
        if (count>0){
            super.withdraw(amount);
            count--;
        }else{
            super.withdraw(amount+bankCharge);
        }
    }

    public double getBankCharge() {
        return bankCharge;
    }

    public void setBankCharge(double bankCharge) {
        this.bankCharge = bankCharge;
    }


}
