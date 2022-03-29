package com.chapter15.GenericExercise2;

import java.util.ArrayList;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        ArrayList<employee> E = new ArrayList<>();
        E.add(new employee("abc", 12000, new MyDate(2001, 01, 01)));
        E.add(new employee("abc", 12000, new MyDate(2001, 04, 01)));
        E.add(new employee("abc", 12000, new MyDate(2001, 03, 01)));
        System.out.println(E);
        E.sort(new Comparator<employee>() {
            @Override
            public int compare(employee o1, employee o2) {
                int temp;
                if (!(o1 instanceof employee && o2 instanceof employee))
                    return 0;
               temp= o1.getName().compareTo(o2.getName());
               if ( temp !=0)
                   return temp;
               return o1.getDir().compareTo(o2.getDir());
            }
        });
        System.out.println(E);
    }
}
