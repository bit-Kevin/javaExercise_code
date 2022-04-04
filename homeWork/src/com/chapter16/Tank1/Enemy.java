package com.chapter16.Tank1;

import java.util.Vector;

public class Enemy extends Tank implements Runnable {

    public Enemy(int x, int y, int direction) {
        super(x, y, direction);
        setSpeed(3);
    }

    Vector<Shot> shots = new Vector<>();


    @Override
    public void run() {
        int distance;//移动距离

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //实现自己随机移动和转向
        while (IsLive) { //判断线程终止条件

            //实现敌方坦克多发子弹 ,上限为5(需要循环判断）
            if (IsLive && shots.size()<5){
                Shot shot = null;
                //创建子弹到敌方坦克的合集里面
                switch (getDirection()) {
                    case 0:
                        shot = new Shot(getX()-1, getY()-30, getDirection());
                        break;
                    case 1:
                        shot = new Shot(getX()+30, getY()-1, getDirection());
                        break;
                    case 2:
                        shot = new Shot(getX()+1, getY()+30, getDirection());
                        break;
                    case 3:
                        shot = new Shot(getX()-30, getY()+1, getDirection());
                        break;
                }
                //添加
                shots.add(shot);
                //启动线程
                new Thread(shot).start();
            }

            //随机移动和转向功能
            switch (getDirection()) {
                case 0:
                    distance = (int) (Math.random() * 100+10 );
                    for (int i = 0; i < distance; i++) {
                        //判断是否碰墙
                        if (getY()>30){
                            MoveUp();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    distance = (int) (Math.random() * 100 +10);
                    for (int i = 0; i < distance; i++) {
                        if (getX()<950){ //窗口遮挡了一些，比实际的要小一点
                            MoveRight();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    distance = (int) (Math.random() * 100 +10);
                    for (int i = 0; i < distance; i++) {
                        if (getY()<680){
                            MoveDown();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    distance = (int) (Math.random() * 100 +10);
                    for (int i = 0; i < distance; i++) {
                        if (getX()>30){
                            MoveLeft();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;


            }
            //自动转向
            int temp = (int) (Math.random() * 4);
            setDirection(temp);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
