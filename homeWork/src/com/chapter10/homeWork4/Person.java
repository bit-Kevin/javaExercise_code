package com.chapter10.homeWork4;

public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;//刚刚出发是默认带一匹马
    }
    //假定过河
    public  void  passRiver(){
        //如果此时没有船就找一个
        if (!(vehicles instanceof boat)){
            vehicles= factory.getBoat();
        }
        //使用船过河
        vehicles.work();
    }
    public void common(){
        //判断是否有马
        if (!(vehicles instanceof horse)){
            vehicles = factory.getHorse();
        }
        vehicles.work();
    }
}
