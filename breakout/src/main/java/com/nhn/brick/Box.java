package com.nhn.brick;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.nhn.object.Paintable;
import com.nhn.object.Regionable;

public class Box implements Regionable, Paintable{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Box(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Box(int x, int y, int width, int height) {
        this(x, y, width, height, Color.pink);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getMinX(), getMinY(), width, height);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getMinX() {
        return getX() - getWidth()/2;
    }
    
    @Override
    public int getMinY() {
        return getY() - getHeight()/2;
    }
    
    @Override
    public int getMaxX() {
        return getX() + getWidth()/2;
    }
    
    @Override
    public int getMaxY() {
        return getY() + getHeight()/2;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("(").append(getX()).append(", ").append(getY()).append(")").toString();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getMinX(), getMinY(), width, height);
    }
    
}
