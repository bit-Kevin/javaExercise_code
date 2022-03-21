package com.chapter13.Exercise1;

public class Book {
    public String name;
    public int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

interface Comparator{
    public int compare(Object o1, Object o2);
        /*
         * 前者减后者返回值大于一 触发下面交换条件 大值后移 可理解为使用者想升序排列
         * 后者减前者返回值大于一 触发下面交换条件 大值前移 可理解为使用者想降序排列*/

}
class tolls{
    public void sort(Book[] books,Comparator c){
        Book temp;
        for ( int i =0;i< books.length-1;i++){
            for (int j = 0;j< books.length-1-i;j++){
                if (c.compare(books[j].price,books[j+1].price)>0){//当判定值大于零触发交换
                    temp =books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }
}
