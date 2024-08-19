package com.nhn;

import com.nhn.exception.OutOfRangeException;

public class Ball {
    private int x;
    private int y;
    private int radius;
    
    public Ball(int x, int y, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }

        if ((long) x + radius > Integer.MAX_VALUE || (long) y + radius > Integer.MAX_VALUE
            || (long) x - radius < Integer.MIN_VALUE || (long) y - radius < Integer.MIN_VALUE) {
            throw new OutOfRangeException();
        }

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

