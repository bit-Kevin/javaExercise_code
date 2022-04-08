package com.chapter16.Tank1;

public class Shot implements Runnable {
    int x;//坦克坐标
    int y;
    int direction;//方向
    int speed = 5;//子弹速度
    int sleepTime=50;
    boolean IsLive = true;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public void run() {//射击
        while (IsLive) {

            //休眠 50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向来改变x,y坐标
            switch (direction) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            //老师测试，这里我们输出x,y的坐标
            //System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁)
            //当子弹碰到敌人坦克时，也应该结束线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 )) {
                //System.out.println("子弹线程退出");
                IsLive = false;
                break;
            }

        }
    }
}
