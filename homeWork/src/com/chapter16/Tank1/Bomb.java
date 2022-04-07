package com.chapter16.Tank1;

public class Bomb {
    int x ;
    int y;//爆炸坐标
    int live=9;//爆炸动画周期
    boolean IsLive=true;

    public Bomb(int x, int y) {
        this.x = x-25;
        this.y = y-25;
    }
    //制作动画过度方法,每次减少动画周期
    public void LiveDown(){
        if (live>0){
            live--;
        }else {
            IsLive = false;//到达零时结束
        }
    }


}
