package com.chapter16.Tank1;

public class Tank {
    private int x;//x坐标
    private int y;//y坐标
    private int direction;
    private int speed  ;
    boolean IsLive=true;


    public void setSpeed(int speed) {
        this.speed = speed;
    }//设置速度

    //移动
    public void MoveUp() {
        if (y > 0 +30) y -= speed;//减30是因为坦克坐标和边界是相差了30的
    }

    public void MoveRight() {
        if (x < 1000-30) x += speed;//窗口遮挡了一些，所以设置为50。不考虑遮挡问题是30
    }

    public void MoveDown() {if (y < 750 -70) y += speed;}

    public void MoveLeft() {
        if (x > 0 +30) x -= speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }//获取方向

    public void setDirection(int direction) {
        this.direction = direction;
    }//设置方向


    public Tank(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    //获取当前坦克坐标
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
