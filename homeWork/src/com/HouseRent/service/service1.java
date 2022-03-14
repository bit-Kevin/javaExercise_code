package com.HouseRent.service;

import com.HouseRent.Utility.utility;
import com.HouseRent.model.house;

public class service1 {
    private house[] houseArr;
    private int houseNums = 2;//记录当前数组里面有多少个房源信息
    private int IdCounter = 2;//ID计数器，用来设置新添加对象的ID

    public service1(int count) {
        houseArr = new house[count];
        houseArr[0] = new house(1, "张三", "12345", "西湖区", 1000, "未出售");
        houseArr[1] = new house(2, "张三", "12345", "西湖区", 1000, "未出售");
    }

    //房源数组的扩容
    public house[] houseArrAdd(house[] oldHouseArr) {
        //在原有数组个数上再增加5个
        house[] newHouseArr = new house[oldHouseArr.length + 5];
        //遍历把旧数组存入新数组
        for (int i = 0; i < oldHouseArr.length; i++) {
            newHouseArr[i] = oldHouseArr[i];
        }
        System.out.println("扩容成功");
        return newHouseArr;
    }

    //添加房源
    public boolean addHouse(house newHouse) {
        if (houseNums == houseArr.length) {
            System.out.println("当前房源数组已满");
            //添加扩容机制
            houseArr = houseArrAdd(houseArr);
        }
        //把新对象加入数组
        houseArr[houseNums++] = newHouse;
        //此时newHouse还指向这个新对象，通过它设置对象ID
        newHouse.setId(++IdCounter);
        //IdCounter使用前加一刚好是新对象的个数，赋值刚刚好
        return true;
    }


    //匹配房源ID
    public int find(int HouseID) {
        int temp;//用来存放匹配的下标
        for (int i = 0; i < houseArr.length; i++) {//匹配ID
            if (houseArr[i].getId() == HouseID) {
                temp = i;
                return temp;
            }
        }
        System.out.println("未找到匹配的房源ID");
        return -1;
    }

    //删除房源
    public boolean deleteHouse(int deleteHouseID) {
        //遍历寻找房源
        int temp = -1;//存放要删除的房源的下标
        String flag;//存放删除指令
        temp = find(deleteHouseID);//调用查找方法
        if (temp == -1) {
            return false;
        }
        System.out.println("已找到房源，请确定是否继续删除（y/n)");
        flag = utility.readString(1, "n");
        if (flag.equals("n")) {
            //放弃删除
            return false;
        } else if (flag.equals("y")) {
            //确认继续删除，删除匹配下标的元素
            //用后面一个元素覆盖来实现删除
            for (int i = temp; i < houseArr.length - 1; i++) {
                //要删除的元素后面一个是null,直接置为null,跳出循环
                if (i == temp && houseArr[i + 1] == null) {
                    houseArr[i] = null;
                    break;
                }
                //后一个为null，把当前i下标置为null，跳出
                if (houseArr[i + 1] == null) {
                    houseArr[i] = null;
                    break;
                }
                //把后面一个赋给当前
                houseArr[i] = houseArr[i + 1];
                houseArr[i + 1] = null;
            }
            //房源计数器减一
            houseNums--;

        } else {
            System.out.println("你输入有误，结束删除");
            return false;
        }

        return true;
    }
    //修改房源信息
    public void upDate(int upDateNum){
        System.out.println(houseArr[upDateNum].getId());
        //修改房主
        System.out.print("房主 "+houseArr[upDateNum].getName()+":");
        String name = utility.readString(5,houseArr[upDateNum].getName());
        houseArr[upDateNum].setName(name);
        //修改联系方式
        System.out.print("电话 "+houseArr[upDateNum].getPhone()+":");
        String phone = utility.readString(11,houseArr[upDateNum].getPhone());
        houseArr[upDateNum].setPhone(phone);
        //修改地址
        System.out.print("地址 "+houseArr[upDateNum].getAddress()+":");
        String address = utility.readString(10,houseArr[upDateNum].getAddress());
        houseArr[upDateNum].setAddress(address);
        //修改租金
        System.out.print("月租 "+houseArr[upDateNum].getMonthlyRent()+":");
        int monthlyRent = utility.readInt(houseArr[upDateNum].getMonthlyRent());
        houseArr[upDateNum].setMonthlyRent(monthlyRent);
        //修改状态
        System.out.print("状态 "+houseArr[upDateNum].getState()+":");
        String state = utility.readString(5,houseArr[upDateNum].getState());
        houseArr[upDateNum].setState(state);
        System.out.println("修改成功");
    }

    //获取已经初始化的房源数组
    public house[] getList() {
        return houseArr;
    }
}
