package com.chapter10.homeWork2;

public class test {
    public static void main(String[] args) {
        cat cat = new cat();
        dog dog = new dog();
        cat.shout();
        dog.shout();
        new Animal(){
            @Override
            public void shout(){
                System.out.println("小鸟喳喳叫");
            }

        }.shout();
    }
}
