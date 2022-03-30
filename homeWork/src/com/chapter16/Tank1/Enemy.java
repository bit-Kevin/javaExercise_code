package com.chapter16.Tank1;

public class Enemy extends Tank {
    public Enemy(int x, int y, int direction) {
        super(x, y, direction);
        setSpeed(3);
    }
}
