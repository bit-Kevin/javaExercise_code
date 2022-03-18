package com.chapter10.homeWork4;

public class  test {
    public static void main(String[] args) {
        Person person= new Person("唐僧",factory.getHorse());
        person.common();
        person.passRiver();
        person.common();
        person.common();
        person.common();
        person.passRiver();

    }
}
