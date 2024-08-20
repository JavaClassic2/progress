package com.nhn.brick;

import com.nhn.object.Movable;

public class Bar extends Box implements Movable{
    private int dx;
    private int dy;

    public Bar(int x, int y, int width, int height) {
        this(x, y, width, height, 0, 0);
    }

    public Bar(int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public int getDx() {
        return dx;
    }

    @Override
    public int getDy() {
        return dy;
    }

    @Override
    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public void setDy(int dy) {
        this.dy = dy;
    }

    @Override
    public void move() {
        moveTo(getX() + getDx(), getY() + getDy());
    }

    @Override
    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }
    
}
