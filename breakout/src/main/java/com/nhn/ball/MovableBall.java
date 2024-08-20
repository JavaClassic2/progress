package com.nhn.ball;

import java.awt.Color;

public class MovableBall extends PaintableBall{
    private static final int DEFAULT_DIFFERENTIAL = 10;
    private int dx;
    private int dy;

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
        this.dx = DEFAULT_DIFFERENTIAL;
        this.dy = DEFAULT_DIFFERENTIAL;
    }
    
    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
        this.dx = DEFAULT_DIFFERENTIAL;
        this.dy = DEFAULT_DIFFERENTIAL;
    }

    public MovableBall(int x, int y, int radius, Color color, int dx, int dy) {
        super(x, y, radius, color);
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void move() {
        moveTo(getX() + getDx(), getY() + getDy());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }
}
