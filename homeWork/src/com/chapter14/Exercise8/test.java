package com.chapter14.Exercise8;

import com.chapter14.Exercise5.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(01,new employee(01,"abc",12000));
        map.put(02,new employee(02,"abd",13000));
        map.put(03,new employee(03,"abe",11000));
        Set entrySet1= map.entrySet();
        System.out.println(entrySet1.getClass());
        Iterator iterator = entrySet1.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();

            Map.Entry e = (Map.Entry) next;
            Object key = e.getKey();
            Object value = e.getValue();
            employee value1 = (employee) value;
            if (value1.salary>11000){
                System.out.println("迭代器："+key+"-"+value);
            }
        }
        for (Object entry : entrySet1) {
            System.out.println(entry.getClass());
            Map.Entry entry1 = (Map.Entry) entry;
            Object key = entry1.getKey();
            employee value1 =(employee) entry1.getValue();
            if (value1.salary>11000){
                System.out.println("for："+key+"-"+value1);
            }
        }


    }
}
class employee{
    int ID ;
    String name;
    double salary;

    public employee(int ID, String name, double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID=" + ID + ", name='" + name + '\'' + ", salary=" + salary ;
    }
}