package com.chapter10.homeWork5;

public class Car {
    public double temperature;
    class Air{
        public void flow(){
            if (temperature>40){
            System.out.println("吹冷风");}
            else if (temperature<0){
                System.out.println("吹暖风");
            }
        }
    }
    public Air air= new Air();


}
