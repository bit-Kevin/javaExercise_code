package com.chapter16.Tank1;

import java.util.Vector;

@SuppressWarnings({"all"})
public class Enemy extends Tank implements Runnable {

    public Enemy(int x, int y, int direction) {
        super(x, y, direction);
        setSpeed(3);
    }

    Vector<Shot> shots = new Vector<>();
    //定义一个用来存放所有敌方坦克
    Vector<Enemy> enemies =new Vector<>();

    public void setEnemies(Vector<Enemy> enemies) {
        this.enemies = enemies;
    }
    public boolean IsCrash(){
        //判断当前坦克的方向
        //定义变量，方便使用
        int x = this.getX(),y=this.getY();
        //竖：vertical 横：across 敌人：enemy   定义 竖 横 的碰撞区间
        switch (this.getDirection()){
            case 0://当前坦克位置向上
                //循环遍历
                for (int i = 0;i<enemies.size();i++){
                    //判断取出对象是否为当前坦克
                    Enemy enemy = enemies.get(i);
                    //不和自己比较
                    if (enemy!=this){
                        /*
                        自己A坐标（x-20，y-30) B坐标(x+20,y-30)
                        敌人竖 碰撞区间 [x-20,x+20][y-30,y+30]
                        敌人横 碰撞区间 [x-30,y+30][y-20,y+20]
                         */
                        //如果敌人坦克竖着
                        if (enemy.getDirection()==0||enemy.getDirection()==2){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+20,EXmin=enemy.getX()-20,
                                    EYmax=enemy.getY()+30,EYmin=enemy.getY()-30;
                            //判断是否与自己的A坐标相交
                            if (x-20<=EXmax && x-20>=EXmin && y-30<=EYmax && y-30>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x+20<=EXmax && x+20>=EXmin && y-30<=EYmax && y-30>=EYmin){
                                return true;
                            }
                        }

                        //如果敌人坦克横着
                        if (enemy.getDirection()==1||enemy.getDirection()==3){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+30,EXmin=enemy.getX()-30,
                                    EYmax=enemy.getY()+20,EYmin=enemy.getY()-20;
                            //判断是否与自己的A坐标相交
                            if (x-20<=EXmax && x-20>=EXmin && y-30<=EYmax && y-30>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x+20<=EXmax && x+20>=EXmin && y-30<=EYmax && y-30>=EYmin){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://当前坦克向右
                //循环遍历
                for (int i = 0;i<enemies.size();i++){
                    //判断取出对象是否为当前坦克
                    Enemy enemy = enemies.get(i);
                    //不和自己比较
                    if (enemy!=this){
                        /*
                        自己A坐标（x+30，y-20) B坐标(x+30,y+20)
                        敌人竖 碰撞区间 [x-20,x+20][y-30,y+30]
                        敌人横 碰撞区间 [x-30,y+30][y-20,y+20]
                         */
                        //如果敌人坦克竖着
                        if (enemy.getDirection()==0||enemy.getDirection()==2){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+20,EXmin=enemy.getX()-20,
                                    EYmax=enemy.getY()+30,EYmin=enemy.getY()-30;
                            //判断是否与自己的A坐标相交
                            if (x+30<=EXmax && x+30>=EXmin && y-20<=EYmax && y-20>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x+30<=EXmax && x+30>=EXmin && y+20<=EYmax && y+20>=EYmin){
                                return true;
                            }
                        }

                        //如果敌人坦克横着
                        if (enemy.getDirection()==1||enemy.getDirection()==3){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+30,EXmin=enemy.getX()-30,
                                    EYmax=enemy.getY()+20,EYmin=enemy.getY()-20;
                            //判断是否与自己的A坐标相交
                            if (x+30<=EXmax && x+30>=EXmin && y-20<=EYmax && y-20>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x+30<=EXmax && x+30>=EXmin && y+20<=EYmax && y+20>=EYmin){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://向下移动
                //循环遍历
                for (int i = 0;i<enemies.size();i++){
                    //判断取出对象是否为当前坦克
                    Enemy enemy = enemies.get(i);
                    //不和自己比较
                    if (enemy!=this){
                        /*
                        自己A坐标（x+20，y+30) B坐标(x-20,y+30)
                        敌人竖 碰撞区间 [x-20,x+20][y-30,y+30]
                        敌人横 碰撞区间 [x-30,y+30][y-20,y+20]
                         */
                        //如果敌人坦克竖着
                        if (enemy.getDirection()==0||enemy.getDirection()==2){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+20,EXmin=enemy.getX()-20,
                                    EYmax=enemy.getY()+30,EYmin=enemy.getY()-30;
                            //判断是否与自己的A坐标相交
                            if (x+20<=EXmax && x+20>=EXmin && y+30<=EYmax && y+30>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x-20<=EXmax && x-20>=EXmin && y+30<=EYmax && y+30>=EYmin){
                                return true;
                            }
                        }

                        //如果敌人坦克横着
                        if (enemy.getDirection()==1||enemy.getDirection()==3){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+30,EXmin=enemy.getX()-30,
                                    EYmax=enemy.getY()+20,EYmin=enemy.getY()-20;
                            //判断是否与自己的A坐标相交
                            if (x+20<=EXmax && x+20>=EXmin && y+30<=EYmax && y+30>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x-20<=EXmax && x-20>=EXmin && y+30<=EYmax && y+30>=EYmin){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://向右移动
                //循环遍历
                for (int i = 0;i<enemies.size();i++){
                    //判断取出对象是否为当前坦克
                    Enemy enemy = enemies.get(i);
                    //不和自己比较
                    if (enemy!=this){
                        /*
                        自己A坐标（x-30，y+20) B坐标(x-30,y-20)
                        敌人竖 碰撞区间 [x-20,x+20][y-30,y+30]
                        敌人横 碰撞区间 [x-30,y+30][y-20,y+20]
                         */
                        //如果敌人坦克竖着
                        if (enemy.getDirection()==0||enemy.getDirection()==2){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+20,EXmin=enemy.getX()-20,
                                    EYmax=enemy.getY()+30,EYmin=enemy.getY()-30;
                            //判断是否与自己的A坐标相交
                            if (x-30<=EXmax && x-30>=EXmin && y+20<=EYmax && y+20>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x-30<=EXmax && x-30>=EXmin && y-20<=EYmax && y-20>=EYmin){
                                return true;
                            }
                        }

                        //如果敌人坦克横着
                        if (enemy.getDirection()==1||enemy.getDirection()==3){
                            //定义敌方碰撞区间的最大值和最小值
                            int EXmax = enemy.getX()+30,EXmin=enemy.getX()-30,
                                    EYmax=enemy.getY()+20,EYmin=enemy.getY()-20;
                            //判断是否与自己的A坐标相交
                            if (x-30<=EXmax && x-30>=EXmin && y+20<=EYmax && y+20>=EYmin){
                                return true;
                            }
                            //判断是否与自己B点坐标相交
                            if (x-30<=EXmax && x-30>=EXmin && y-20<=EYmax && y-20>=EYmin){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

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
                        if (getY()>30&&!IsCrash()){
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
                        if (getX()<950&&!IsCrash()){ //窗口遮挡了一些，比实际的要小一点
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
                        if (getY()<680&&!IsCrash()){
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
                        if (getX()>30&&!IsCrash()){
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
