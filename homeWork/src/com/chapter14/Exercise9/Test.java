package com.chapter14.Exercise9;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList A = new ArrayList();
        A.add("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        A.add("男子突然想起两个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        for (int i = A.size()-1;i>=0;i--){
            JieQu(A.get(i));
        }
    }
    public static void JieQu(Object s){
        String temp = (String)s;
        if (s==null){
            return;
        }
        System.out.println(temp.substring(0,15)+"...");
    }
}
class news{
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "news{" +
                "title='" + title + '\'' +
                '}';
    }
}
