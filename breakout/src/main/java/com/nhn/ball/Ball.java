package com.nhn.ball;

import java.awt.Rectangle;

import com.nhn.exception.OutOfRangeException;
import com.nhn.object.Regionable;

public class Ball implements Regionable{
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getMinX() {
        return getX() - getRadius();
    }

    public int getMinY() {
        return getY() - getRadius();
    }

    public int getMaxX() {
        return getX() + getRadius();
    }

    public int getMaxY() {
        return getY() + getRadius();
    }

    public int getWidth() {
        return 2 * getRadius();
    }

    public int getHeight() {
        return 2 * getRadius();
    }

    public Rectangle getBounds() {
        return new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getRadius() + ")";
    }
}

