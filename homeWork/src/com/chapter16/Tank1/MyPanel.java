package com.chapter16.Tank1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class MyPanel extends JPanel implements KeyListener {//画板
    Hero hero = null;
    ArrayList<Enemy>  enemies= new ArrayList<>();
    //初始化自己坦克
    public MyPanel() {
        hero = new Hero(100, 100,0);
        enemies.add(new Enemy(200,100,0));
        enemies.add(new Enemy(400,100,0));
        enemies.add(new Enemy(600,100,0));

    }

    @Override
    public void paint(Graphics g) {//定义一支笔(符号）
        super.paint(g);
        //调用笔所提供的的方法
        g.fillRect(0, 0, 1000, 750);
        DrawTank(hero.getX(), hero.getY(), hero.getDirection(), 0, g);
        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy next =  iterator.next();
            DrawTank(next.getX(),next.getY(),next.getDirection(),1,g);
        }

    }

    //封装自己的坦克
    public void DrawTank(int x, int y, int direction, int type, Graphics g) {
        switch (type) {
            case 0://自己的坦克，添加颜色
                g.setColor(Color.cyan);
                break;
            case 1://敌人坦克，类型1
                g.setColor(Color.yellow);
                break;
        }
        switch (direction) {
            case 0://坦克向上
                g.fill3DRect(x-20, y-30, 10, 60, false);//A部分左履带
                g.fill3DRect(x +10, y-30, 10, 60, false);//B 右侧履带
                g.fill3DRect(x -10, y -20, 20, 40, false);//C 车体
                g.fillOval(x -10, y -10, 20, 20);//D 炮塔
                g.drawLine(x , y, x , y -30);
                break;
            case 1://坦克右转
                g.fill3DRect(x-30, y-20, 60, 10, false);//A部分左履带
                g.fill3DRect(x-30, y + 10, 60, 10, false);//B 右侧履带
                g.fill3DRect(x -20, y -10, 40, 20, false);//C 车体
                g.fillOval(x -10, y -10, 20, 20);//D 炮塔
                g.drawLine(x , y , x + 30, y );
                break;
            case 2://坦克向下
                g.fill3DRect(x-20, y-30, 10, 60, false);//A部分左履带
                g.fill3DRect(x +10, y-30, 10, 60, false);//B 右侧履带
                g.fill3DRect(x -10, y -20, 20, 40, false);//C 车体
                g.fillOval(x -10, y -10, 20, 20);//D 炮塔
                g.drawLine(x , y, x , y +30);
                break;
            case 3://坦克左转
                g.fill3DRect(x-30, y-20, 60, 10, false);//A部分左履带
                g.fill3DRect(x-30, y + 10, 60, 10, false);//B 右侧履带
                g.fill3DRect(x -20, y -10, 40, 20, false);//C 车体
                g.fillOval(x -10, y -10, 20, 20);//D 炮塔
                g.drawLine(x , y , x - 30, y );
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            hero.setDirection(0);
            hero.MoveUp();
        }else  if(e.getKeyCode()==KeyEvent.VK_S){
            hero.setDirection(2);
            hero.MoveDown();
        }else if (e.getKeyCode()==KeyEvent.VK_A){
            hero.setDirection(3);
            hero.MoveLeft();
        }else if (e.getKeyCode()==KeyEvent.VK_D){
            hero.setDirection(1);
            hero.MoveRight();
        }
        this.repaint();//再次调用repaint让面板重新打印
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
