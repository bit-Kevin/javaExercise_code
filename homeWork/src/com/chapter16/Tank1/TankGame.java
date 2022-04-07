package com.chapter16.Tank1;

import javax.swing.*;
public class TankGame extends JFrame {//继承窗口
    //定义一个画板
    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }

    public TankGame() {
        //初始化画板
        mp = new MyPanel();

        //启动画板线程
        Thread thread = new Thread(mp);
        thread.start();
        //把画板添加到窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(1300, 750);
        //叉掉窗口，结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗口可见
        this.setVisible(true);
        //窗口调用键盘事件
        this.addKeyListener(mp);
    }
}
