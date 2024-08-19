package com.nhn;

public class Ball {
    private int x;
    private int y;
    private int radius;
    
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getRadius() + ")";
    }
}

