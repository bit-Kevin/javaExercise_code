package com.chapter01.exercise1;

public class demo {
    public static void main(String[] args) {
        person[] arr = new person[3];
        arr[0] = new person("dave", 18, "waiter");
        arr[1] = new person("kevin", 22, "student");
        arr[2] = new person("yyy", 16, "student");
        person temp = new person();
        //开始比较
        for (int i =0;i< arr.length-1;i++){
            for (int j =0;j< arr.length-1-i;j++){
                if (arr[j].age>arr[j+1].age){
                    temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        for (int i = 0 ;i< arr.length;i++){
            System.out.println("name:"+arr[i].name+"\tage:"+arr[i].age+"\tjob"+arr[i].job);
        }

    }
}
