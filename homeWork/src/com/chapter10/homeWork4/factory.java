package com.chapter10.homeWork4;

public class factory {
    private static horse horse = new horse();
    private factory(){}
    public static horse getHorse(){
        return  horse;
    }
    public static boat getBoat(){
        return new boat();
    }
}
