package com.nhn.world;

import java.util.List;

import com.nhn.ball.Ball;
import com.nhn.ball.MovableBall;
import com.nhn.exception.OutOfBoundsException;

public class BoundedWorld extends MovableWorld{
    public BoundedWorld(){
        super();
    }

    public BoundedWorld(int maxMoveCount, int dt) {
        super(maxMoveCount, dt);
    }

    @Override
    public void add(Ball ball) {
        for (Ball b : getBallList()) {
            if (b.getBounds().intersects(ball.getBounds())) {
                throw new OutOfBoundsException();
            }
        }

        super.add(ball);
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
                    }
                }
            }
        }
    }

    private void checkCollision(MovableBall b1, MovableBall b2) {
        if (b1.getBounds().intersects(b2.getBounds())){
            if (b2.getMinX() < b1.getMinX()  && b1.getMinX() < b2.getMaxX()
                || b2.getMinX() < b1.getMaxX() && b1.getMaxX() < b2.getMaxX()) {
                b2.setDx(-b2.getDx());
                b1.setDx(-b1.getDx());
            }
    
            if (b2.getMaxY() > b1.getMinY() && b1.getMinY() > b2.getMinY()
                || b2.getMaxY() > b1.getMaxY() && b1.getMaxY() > b2.getMinY()) {
                b2.setDy(-b2.getDy());
                b1.setDy(-b1.getDy());
            }
        }
    }

    private void checkOutOfbounds(MovableBall b1) {
        if (b1.getMinX() < getBounds().getMinX()) {
            b1.setDx(-b1.getDx());
            b1.moveTo((int)getBounds().getMinX() + b1.getRadius(), b1.getY());
        }
        
        if ( b1.getMaxX() > getBounds().getMaxX()) {
            b1.setDx(-b1.getDx());
            b1.moveTo((int)getBounds().getMaxX() - b1.getRadius(), b1.getY());
        }

        if (b1.getMinY() < getBounds().getMinY()){
            b1.setDy(-b1.getDy());
            b1.moveTo(b1.getX(), (int)getBounds().getMinY() + b1.getRadius());
        }
        
        if (b1.getMaxY() > getBounds().getMaxY()) {
            b1.setDy(-b1.getDy());
            b1.moveTo(b1.getX(), (int)getBounds().getMaxY() - b1.getRadius());
        }   
    }

}
