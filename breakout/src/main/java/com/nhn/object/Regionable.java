package com.nhn.object;

import java.awt.Rectangle;

public interface Regionable{
    Rectangle getBounds();
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    int getMinX();
    int getMinY();
    int getMaxX();
    int getMaxY();
    int getWidth();
    int getHeight();
}
