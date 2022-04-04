package com.chapter16.Tank1;

import java.util.Vector;

public class Hero extends Tank{
    Shot shot =null;
    //创建子弹集合
     Vector<Shot> shots = new Vector<>();
    public Hero(int x, int y, int direction) {
        super(x, y, direction);
        setSpeed(3);
    }
    //射击
    public void shotEnemy(){
        //创建shot对象
        switch (getDirection()) {
            case 0:
                shot = new Shot(getX(), getY()-30, getDirection());
                break;
            case 1:
                shot = new Shot(getX()+30, getY(), getDirection());
                break;
            case 2:
                shot = new Shot(getX(), getY()+30, getDirection());
                break;
            case 3:
                shot = new Shot(getX()-30, getY(), getDirection());
                break;
        }
        //把子弹加入集合
        shots.add(shot);
        //启动子弹线程
        new Thread(shot).start();
    }
}
