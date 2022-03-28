package com.SeatWork.Exercise1;

public class TEST {
    public static void main(String[] args) {
        CPU cpu = new CPU();//1.创建CPU
        cpu.setSpeed(2200);//2.将speed设置为2200
        HardDisk hardDisk = new HardDisk();//3.创建HardDisk
        hardDisk.setAmount(200);//4.将amount设置为200
        PC pc = new PC(cpu,hardDisk);//5.创建对象时直接传实参
        pc.show();//6.调用show方法
    }
}
class CPU{
    private int speed;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
class HardDisk{
    private  int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
class PC{
    private CPU cpu;
    private HardDisk HD;
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public void setHD(HardDisk HD) {
        this.HD = HD;
    }
    public PC(CPU cpu, HardDisk HD) {
        setCpu(cpu);//构造器调用set方法，进行赋值
        setHD(HD);
    }
    public void show(){//输出
        System.out.println("speed="+cpu.getSpeed()+"\namount="+HD.getAmount());
    }
}
