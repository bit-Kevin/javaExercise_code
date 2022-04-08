package com.chapter16.Tank1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Vector;

public class Recorder {
    //定义敌方坦克集合，方便保存游戏
    public static Vector<Enemy> enemies = new Vector<>();

    //传入敌方坦克
    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }
    //定义node节点，方便恢复数据
    public static Vector<Node> nodes = new Vector<>();
    //定义hero变量
    public static Hero hero =null;
    public static void setHero(Hero hero){
        Recorder.hero=hero;
    }


    //用来存放玩家击中敌人的数量
    public static int count =0;
    //定义保存路径
    public static String FIlePath = "G:\\gameRecord.txt";

    public static String getFIlePath() {
        return FIlePath;
    }

    //定义包装流
    public static BufferedWriter bw = null;
    public static BufferedReader br = null;
    @Test
    public void test(){

    }
    public static Vector<Node> Recover(){
        String temp;
        //从文件里读取数据
        try {
            br = new BufferedReader(new FileReader(FIlePath));
            //读入击败信息
            count= Integer.parseInt(br.readLine());
            //读取余下的所有数据,第二个为hero
            while ((temp=br.readLine())!=null){
                String[] temps= temp.split(" ");
                nodes.add(new Node(Integer.parseInt(temps[0]),Integer.parseInt(temps[1]),Integer.parseInt(temps[2])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }
    public static void Record(){
        try {
            bw = new BufferedWriter(new FileWriter(FIlePath));
            bw.write(count+"\r\n");
            //再保存hero的坐标
            bw.write(hero.getX()+" "+hero.getY()+" "+hero.getDirection()+"\r\n");
            //循环保存敌方坦克坐标 和方向
            for (int i =0;i<enemies.size();i++ ){
                Enemy enemy= enemies.get(i);
                String record = enemy.getX()+" "+enemy.getY()+" "+enemy.getDirection();
                bw.write(record+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
