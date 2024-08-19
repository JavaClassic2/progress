package com.nhn.world;

import java.util.List;

import com.nhn.ball.Ball;
import com.nhn.ball.MovableBall;

public class BoundedWorld extends MovableWorld{
    public BoundedWorld(){
        super();
    }

    public BoundedWorld(int maxMoveCount, int dt) {
        super(maxMoveCount, dt);
    }

    @Override
    public void move(){
        List<Ball> ballList = getBallList();
        for (int i=0; i<ballList.size(); i++) {
            if (ballList.get(i) instanceof MovableBall){
                MovableBall b1 = (MovableBall)ballList.get(i);
                checkOutOfbounds(b1);
                b1.move();
                plusMoveCount();
                repaint();

                for (int j = i+1; j<ballList.size(); j++) {
                    if (ballList.get(j) instanceof MovableBall) {
                        MovableBall b2 = (MovableBall)ballList.get(j);
                        checkCollision(b1, b2);
                        b2.move();
                        plusMoveCount();
                        repaint();
                    }
                }
            }
        }
    }

    private void checkCollision(MovableBall b1, MovableBall b2) {
        if (b1.getX()-b1.getRadius() > b2.getX()-b2.getRadius() && b1.getX()-b1.getRadius() < b2.getX()+b2.getRadius()
            || b2.getX()+b2.getRadius() < b1.getX()+b1.getRadius() && b1.getX()+b1.getRadius() > b2.getX()-b2.getRadius()) {
            b2.setDx(-b2.getDx());
        }

        if (b1.getY()-b1.getRadius() < b2.getY()+b2.getRadius() && b1.getY()-b1.getRadius() > b2.getY()-b2.getRadius()
        || b2.getY()-b2.getRadius() < b1.getY()+b1.getRadius() && b1.getY()-b1.getRadius() < b2.getY()-b2.getRadius()) {
            b2.setDy(-b2.getDx());
        }
    }

    private void checkOutOfbounds(MovableBall b1) {
        if (b1.getX()-b1.getRadius() < 0 || b1.getX()+b1.getRadius() > getWidth()) {
            b1.setDx(-b1.getDx());
        }

        if (b1.getY()-b1.getRadius() < 0 || b1.getY()+b1.getRadius() > getHeight()) {
            b1.setDy(-b1.getDy());
        }
    }

}
