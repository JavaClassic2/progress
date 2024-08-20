package com.nhn.object;

public interface Movable extends Regionable{
    int getDx();
    int getDy();
    void setDx(int dx);
    void setDy(int dy);
    void move();
    void moveTo(int x, int y);
}
