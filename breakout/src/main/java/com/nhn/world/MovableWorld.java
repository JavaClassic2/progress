package com.nhn.world;

import com.nhn.object.Regionable;
import com.nhn.object.Movable;

public class MovableWorld extends World{
    private int maxMoveCount;
    private int moveCount;
    private int dt;

    public MovableWorld() {
        this(0, 10);
    }

    public MovableWorld(int maxMoveCount, int dt) {
        super();
        this.maxMoveCount = maxMoveCount;
        this.dt = dt;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getDt() {
        return dt;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void reset() {
        moveCount = 0;
    }

    public void plusMoveCount(){
        moveCount++;
    }

    public void move() {
        for (Regionable regionable : getRegionableList()) {
            if (regionable instanceof Movable) {
                ((Movable)regionable).move();
            }
        }
        moveCount++;
        repaint();
    }

    public void run() {
        while(getMaxMoveCount() == 0 || getMoveCount() <= getMaxMoveCount()) {
            move();
            try {
                Thread.sleep(getDt());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
