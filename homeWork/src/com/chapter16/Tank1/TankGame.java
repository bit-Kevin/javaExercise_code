package com.chapter16.Tank1;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankGame extends JFrame {//继承窗口
    //定义一个画板
    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }

    public TankGame() {
        //是继续游戏还是新游戏
        System.out.println("===1 继续游戏===2 新游戏===");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        //初始化画板
        mp = new MyPanel(key);

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
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到关闭指令");
                //调用Record方法
                Recorder.Record();
                //调用虚拟机退出方法,传入一个结束值（随便什么数字）
                System.exit(0);
            }
        });
    }
}
