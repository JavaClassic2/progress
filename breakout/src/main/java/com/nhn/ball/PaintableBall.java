package com.nhn.ball;
import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball {
    public static final Color DEFAULT_COLOR = Color.PINK;
    private Color color;

    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
    }

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
    }
}