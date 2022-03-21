package com.chapter13.Exercise1;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Book []  books  = new Book[4];
        books[0] =new Book("红楼梦",100);
        books[1] =new Book("金瓶梅",90);
        books[2] =new Book("西游记",80);
        books[3] =new Book("java入门到放弃",300);
        tolls A = new tolls() ;
        A.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
                return i2-i1;
                /*
                 * 前者减后者返回值大于一 触发下面交换条件 大值后移 可理解为使用者想升序排列
                 * 后者减前者返回值大于一 触发下面交换条件 大值前移 可理解为使用者想降序排列*/
            }
        });
        for (Book book:books){
            System.out.println(book.price);
        }
    }
}
