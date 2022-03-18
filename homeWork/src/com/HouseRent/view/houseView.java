package com.HouseRent.view;

import com.HouseRent.Utility.utility;
import com.HouseRent.model.house;
import com.HouseRent.service.service1;

public class houseView {
    private boolean flag = true;//控制循环
    private char key;//选择需要进行的操作
    private house[] houseArr;//存储房屋列表的数组
    service1 service = new service1(2);//初始化房源数组

    //获取全部房源信息
    public void listView() {
        houseArr = service.getList();
        System.out.println("===============房屋列表===============");
        System.out.println("编号\t\t姓名\t\t号码\t\t地址\t\t租金\t\t状态");
        for (int i = 0; i < houseArr.length; i++) {
            if (houseArr[i] == null) {//判断是否为空，是的话结束输出
                break;
            }
            //调用toString方法答应出信息
            System.out.println(houseArr[i].toString());

        }
    }

    //添加新的房源
    public void addHouse() {
        System.out.print("姓名：");
        String name = utility.readString(5);
        System.out.print("号码：");
        String phone = utility.readString(11);
        System.out.print("地址：");
        String address = utility.readString(15);
        System.out.print("租金：");
        int rent = utility.readInt();
        System.out.print("状态：");
        String state = utility.readString(8);
        //创建新的房源对象
        int temp = 0;//定义一个临时ID传入对象
        house newHouse = new house(temp, name, phone, address, rent, state);
        //把新的房源对象添加到房源数组里面去
        if (service.addHouse(newHouse)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    //查找房源
    public void findView() {
        //输出提示信息
        System.out.println("请输入你要查找的房源ID：");
        int findID = utility.readInt();
        //ID判断
        if (findID < 0) {
            System.out.println("你输入的房源ID有误");
            return;
        }
        //开始查找匹配的ID
        int temp = service.find(findID);
        if (temp == -1) {
            System.out.println("查找结束");
            //结束程序
            return;
        }
        //输出信息
        System.out.println(houseArr[temp].toString());
    }

    //删除一个房源
    public void deleteHouse() {
        //输出提示信息
        System.out.println("请输入要删除的ID：");
        int deleteID = utility.readInt();
        //ID判断
        if (deleteID < 0) {
            System.out.println("你输入的房源ID有误");
            return;
        }
        //开始查找匹配的ID
        if (service.deleteHouse(deleteID)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //更新房源信息
    public void upDate() {
        //输出提示信息
        System.out.println("请输入你修改要的房源ID：");
        int upDateID = utility.readInt();
        //ID判断
        if (upDateID < 0) {
            System.out.println("你输入的房源ID有误");
            return;
        }
        //开始查找匹配的ID
        int temp = service.find(upDateID);
        if (temp == -1) {
            System.out.println("修改结束");
            //结束程序
            return;
        }
        //开始修改
        service.upDate(temp);
        //打印确认一遍
        System.out.println(houseArr[temp].toString());
    }

    //打印菜单
    public void menu() {
        do {
            System.out.println("========================房屋出租管理菜单======================");
            System.out.println("\t\t\t\t1 添 加 房 源");
            System.out.println("\t\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t\t3 删 除 房 源 信 息");
            System.out.println("\t\t\t\t4 修 改 房 源 信 息");
            System.out.println("\t\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t\t6 退      出");
            System.out.println("请选择1~6");
            key = utility.readChar();
            switch (key) {
                case '1':
                    addHouse();//添加房源信息
                    break;
                case '2':
                    findView();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    upDate();
                    break;
                case '5':
                    listView();//打印出所有房源列表
                    break;
                case '6':
                    flag = false;
                    break;
                default:
                    System.out.println("你输入的数有误");
            }
        } while (flag);
    }
}
