package com.chapter14.Exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义","罗贯中",10.1));
        col.add(new Book("三国演","罗贯中",9.8));
        col.add(new Book("三国","罗贯中",23.4));
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);

        }
        iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);

        }

    }
}
class Book {
    public String name;
    public String writer;
    public double price;

    public Book(String name, String writer, double price) {
        this.name = name;
        this.writer = writer;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                '}';
    }
}
