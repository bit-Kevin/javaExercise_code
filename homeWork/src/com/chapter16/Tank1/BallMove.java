package com.chapter16.Tank1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {
    MyPanel2 myPanel2=null;
    public static void main(String[] args) {
        new BallMove();
    }
    public BallMove(){
        myPanel2 = new MyPanel2();
        this.add(myPanel2);
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(myPanel2);
    }

}
class MyPanel2 extends JPanel implements KeyListener {//画板
    int x =10;
    int y=10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char) e.getKeyCode()+"被使用了");
        if(e.getKeyCode()==KeyEvent.VK_W){
            y--;
        }else  if(e.getKeyCode()==KeyEvent.VK_S){
            y++;
        }else if (e.getKeyCode()==KeyEvent.VK_A){
            x--;
        }else if (e.getKeyCode()==KeyEvent.VK_D){
            x++;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

