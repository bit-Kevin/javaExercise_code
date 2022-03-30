package com.chapter16.Tank1;

public class Tank {
    private int x ;//x坐标
    private int y;//y坐标
    private int direction;
    private int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void MoveUp(){
        y -= speed;
    }
    public void MoveRight(){
        x += speed;
    }
    public void MoveDown(){
        y += speed;
    }
    public void MoveLeft(){
        x -= speed;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    public Tank(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
