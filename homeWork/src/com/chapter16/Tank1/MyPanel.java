package com.chapter16.Tank1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {//画板
    Hero hero = null;

    //定义敌人坦克集合
    Vector<Enemy> enemies = new Vector<>();

    //定义爆炸集合，每次刷新判断是否有爆炸任务
    Vector<Bomb> bombs = new Vector<>();
    //定义爆炸时的三张图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    //初始化自己及敌人坦克坦克
    public MyPanel() {
        hero = new Hero(100, 100, 0);
        for (int i = 0; i < 3; i++) {
            Enemy enemy = new Enemy(200 * (i + 1), 100, 2);
            //给敌人添加一发炮弹
            Shot shot = (new Shot(enemy.getX(), enemy.getY() + 30, enemy.getDirection()));
            //启动第一发炮弹线程
            new Thread(shot).start();
            //启动敌人线程
            new Thread(enemy).start();
            //添加炮弹
            enemy.shots.add(shot);
            //添加敌人对象
            enemies.add(enemy);


            //让敌人跑起来
            //new Thread(enemy).start();  重复启动同一敌人线程导致两个线程同时操控一个敌人 ，从而导致鬼畜和漂移（不是switch传透导致的）
        }
        //初始化时定义图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {//定义一支笔(符号）
        super.paint(g);
        //调用笔所提供的的方法
        g.fillRect(0, 0, 1000, 750);

        //画出玩家坦克,玩家坦克存活就打印，否则不打印，后期可以添加游戏结束动画
        if (hero.IsLive){
            DrawTank(hero.getX(), hero.getY(), hero.getDirection(), 0, g);
        }
        //画子弹hero.shot.IsLive==true && hero.shot!=null
        //必须先判断是否为空，再去验证里面的内容，不为空才能再判断里面的某个属性。反过来先判断里面的内容，如果它本身为空，还去访问就会报错。
//        if (hero.shot != null && hero.shot.IsLive == true) {
//            g.draw3DRect(hero.shot.x, hero.shot.y, 2, 2, false);
//        }
        //打印出所有hero所有子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.IsLive == true) {
                //画出还在运行的子弹
                g.draw3DRect(shot.x, shot.y, 2, 2, false);
            } else {
                //移除生命周期结束的子弹
                hero.shots.remove(shot);
            }
        }

        //判断是否有爆炸效果需要画出来,每次只画一张。这一直会刷新
        if (bombs.size() > 0) {
            for (int i = 0; i < bombs.size(); i++) {
                //取出爆炸
                Bomb bomb = bombs.get(i);
                if (bomb.live == 0) {
                    bombs.remove(i);
                }
                if (bomb.live > 6) {
                    g.drawImage(image1, bomb.x, bomb.y, 50, 50, this);
                } else if (bomb.live > 3) {
                    g.drawImage(image2, bomb.x, bomb.y, 50, 50, this);
                } else {
                    g.drawImage(image3, bomb.x, bomb.y, 50, 50, this);
                }
                //画完一张，减少动画周期一次
                bomb.LiveDown();
            }
        }

        //画出敌人坦克和所有子弹
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.IsLive) {//判断坦克是否存活
                DrawTank(enemy.getX(), enemy.getY(), enemy.getDirection(), 1, g);
                //画出敌人子弹
                for (int j = 0; j < enemy.shots.size(); j++) {
                    //循环取出子弹对象
                    Shot shot = enemy.shots.get(j);
                    if (shot != null && shot.IsLive == true) {

                        //new Thread(enemy.shots.get(j)).start();//发射子弹  在构造器里面已经启动第一颗线程 这里在启动是错误的，会加快子弹速度

                        //单纯的画出子弹就好，第一发已经在构造器里面已经启动了。后续子弹会在其他地方启动
                        g.draw3DRect(enemy.shots.get(j).x, enemy.shots.get(j).y, 2, 2, false);
                    } else {
                        enemy.shots.remove(j);
                    }
                }
            }
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
                g.fill3DRect(x - 20, y - 30, 10, 60, false);//A部分左履带
                g.fill3DRect(x + 10, y - 30, 10, 60, false);//B 右侧履带
                g.fill3DRect(x - 10, y - 20, 20, 40, false);//C 车体
                g.fillOval(x - 10, y - 10, 20, 20);//D 炮塔
                g.drawLine(x, y, x, y - 30);
                break;
            case 1://坦克右转
                g.fill3DRect(x - 30, y - 20, 60, 10, false);//A部分左履带
                g.fill3DRect(x - 30, y + 10, 60, 10, false);//B 右侧履带
                g.fill3DRect(x - 20, y - 10, 40, 20, false);//C 车体
                g.fillOval(x - 10, y - 10, 20, 20);//D 炮塔
                g.drawLine(x, y, x + 30, y);
                break;
            case 2://坦克向下
                g.fill3DRect(x - 20, y - 30, 10, 60, false);//A部分左履带
                g.fill3DRect(x + 10, y - 30, 10, 60, false);//B 右侧履带
                g.fill3DRect(x - 10, y - 20, 20, 40, false);//C 车体
                g.fillOval(x - 10, y - 10, 20, 20);//D 炮塔
                g.drawLine(x, y, x, y + 30);
                break;
            case 3://坦克左转
                g.fill3DRect(x - 30, y - 20, 60, 10, false);//A部分左履带
                g.fill3DRect(x - 30, y + 10, 60, 10, false);//B 右侧履带
                g.fill3DRect(x - 20, y - 10, 40, 20, false);//C 车体
                g.fillOval(x - 10, y - 10, 20, 20);//D 炮塔
                g.drawLine(x, y, x - 30, y);
                break;
        }
    }

    //击中坦克
    public void HitTank(Shot shot, Tank tank) {
        switch (tank.getDirection()) {
            case 0:
            case 2:
                if (shot.x < tank.getX() + 20 && shot.x > tank.getX() - 20
                        && shot.y < tank.getY() + 30 && shot.y > tank.getY() - 30) {
                    //坦克是死的就移除，避免尸体吃子弹
                    if (tank instanceof Enemy) {
                        enemies.remove(tank);
                    }
                    //玩家死亡 通过不打印来移除hero
                    shot.IsLive = false;
                    tank.IsLive = false;
                    bombs.add(new Bomb(tank.getX() - 25, tank.getY() - 25));
                }
                break;
            case 1:
            case 3:
                if (shot.x < tank.getX() + 30 && shot.x > tank.getX() - 30
                        && shot.y < tank.getY() + 20 && shot.y > tank.getY() - 20) {
                    //坦克是死的就移除，避免尸体吃子弹
                    if (tank instanceof Enemy) {
                        enemies.remove(tank);
                    }
                    shot.IsLive = false;
                    tank.IsLive = false;
                    bombs.add(new Bomb(tank.getX() - 25, tank.getY() - 25));
                }
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.MoveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.MoveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.MoveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.MoveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //限制最大存活子弹数目为4
            if (hero.shots.size() < 3) {
                hero.shotEnemy();
            }
        }
        this.repaint();//再次调用repaint让面板重新打印
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //判断自己多颗子弹是否击中坦克
    public void IsHitEnemy() {
        Enemy enemy;
        for (Shot shot : hero.shots) {
            if (shot != null) {
                //循环判断当前子弹是否命中了敌人
                for (int i = 0; i < enemies.size(); i++) {
                    enemy = enemies.get(i);
                    HitTank(shot, enemy);
                }
            }
        }
    }

    //判断敌人是否击中自己
    public void IsHitHero() {
        //判断所有敌人
        for (Enemy enemy : enemies) {
            //取出坦克所有子弹进行判断
            if (enemy.shots.size() > 0 && enemy.IsLive) {
                for (Shot shot : enemy.shots) {
                    if (shot != null && shot.IsLive) {
                        HitTank(shot, hero);
                    }
                }
            }
        }
    }

    @Override
    public void run() {//把画板线程化，无时无刻都在刷新

        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断自己多颗子弹是否击中坦克
            IsHitEnemy();
            //判断敌人是否击中自己
            IsHitHero();
            //重新打印
            this.repaint();
        }
    }
}
