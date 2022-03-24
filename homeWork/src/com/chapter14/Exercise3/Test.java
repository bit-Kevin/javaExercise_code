package com.chapter14.Exercise3;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List c = new ArrayList();
        c.add(new Book("三国演义","罗贯中",10.1));
        c.add(new Book("三国演","罗贯中",9.1));
        c.add(new Book("三义","罗贯中",1.1));
        sort(c);
        System.out.println(c);

    }
    public static void sort(List list){
        for (int i =0;i<list.size()-1;i++){
            for (int j = 0;j<list.size()-1-i;j++){
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if (book1.price> book2.price){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
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
        return "name='" + name  + "\twriter='" + writer  + "\t price=" + price ;
    }
}


