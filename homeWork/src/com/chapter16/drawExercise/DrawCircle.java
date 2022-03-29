package com.chapter16.drawExercise;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{//JFrame 是一个窗口类
    //定义一个画板
    private MyPanel mp=null;
    public static void main(String[] args) {
    new DrawCircle();
    }
    public DrawCircle(){
        //初始化画板
        mp = new MyPanel();
        //把画板放入窗口（画框）
        this.add(mp);
        //设置窗口大小
        this.setSize(400,400);
        //叉掉窗口，结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗口可见
        this.setVisible(true);
    }
}
//先定义一个MyPanel，继承JPanel类，画图形
class MyPanel extends JPanel{
    //1.MyPanel 对象就是一个画板
    //2.Graphics g 把 g 理解为一只画笔
    //3.Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g){//绘图方法
        g.drawOval(20,20,200,200);//画一个圆
    }
}
