package com.chapter13;

import java.util.Arrays;
import java.util.Comparator;

public class arrSortAuto {
    public static void main(String[] args) {
        int[] arr = { 2,3,-1,-7,6};
        bubble(arr, new Comparator() {
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
        System.out.println(Arrays.toString(arr));

    }
    public static void bubble(int [] arr, Comparator c){
        int temp;
        for ( int i =0;i< arr.length-1;i++){
            for (int j = 0;j< arr.length-1-i;j++){
                if (c.compare(arr[j],arr[j+1])>0){//当判定值大于零触发交换
                    temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
