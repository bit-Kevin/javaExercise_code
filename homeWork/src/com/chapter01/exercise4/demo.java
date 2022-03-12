package com.chapter01.exercise4;

public class demo {
    public static void main(String[] args) {
        person[] arr = new person[4];
        arr[0] = new teacher("张三",21,"男",0,"篮球");
        arr[1] = new teacher("李四",32,"男",9,"足球");
        arr[2] = new student("九龄",22,"女",11112222,"拍视频");
        arr[3] = new student("凯文",21,"男",23251700,"看视频");
        //按年龄排序
        demo demo = new demo();
        arr = demo.sort(arr);
        for (int i = 0;i<arr.length;i++){
            //调用方法进行打印
            demo.print(arr[i]);
            System.out.println("===================================");
        }
    }
    //把person数组进行冒泡排序
    public person[] sort(person[] arr){
        person temp = new person();
        for (int i =0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j].getAge() <  arr[j+1].getAge()){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    //打印个人信息
    public void print(person A){
        if (A instanceof student){
            //如果是学生向下转型就打印学生特有方法
            student s =(student) A;
            System.out.println("name:"+s.getName()+"\nage:"+s.getAge()+"\nsex:"+s.getSex()+"\n"+s.getStudentNum()+s.study()+s.play());
            System.out.println(s);//测试toString方法
            return;
        }
        if (A instanceof teacher){
            //如果是老师就向下转型打印老师特有方法
            teacher t =(teacher) A;
            System.out.println("name:"+t.getName()+"\nage:"+t.getAge()+"\nsex:"+t.getSex()+"\nworkAge:"+t.getWorkAge()+ t.teach()+t.play());
            System.out.println(t);
            return;
        }
        System.out.println("你输入的参数有误");
    }
}
