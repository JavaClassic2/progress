package com.nhn.world;

import java.util.List;

import com.nhn.exception.OutOfBoundsException;
import com.nhn.object.Regionable;
import com.nhn.object.Movable;

public class BoundedWorld extends MovableWorld{
    public BoundedWorld(){
        super();
    }

    public BoundedWorld(int maxMoveCount, int dt) {
        super(maxMoveCount, dt);
    }

    @Override
    public void add(Regionable regionable) {
        for (Regionable r : getRegionableList()) {
            if (r.getBounds().intersects(regionable.getBounds())) {
                throw new OutOfBoundsException();
            }
        }

        super.add(regionable);
    }

    @Override
    public void move(){
        List<Regionable> regionableList = getRegionableList();
        for (int i=0; i<regionableList.size(); i++) {
            if (regionableList.get(i) instanceof Movable){
                Movable m1 = (Movable)regionableList.get(i);
                checkOutOfbounds(m1);
                    
                m1.move();
                plusMoveCount();
                repaint();
                
                for (int j = i+1; j<regionableList.size(); j++) {
                    if (regionableList.get(j) instanceof Movable){
                        Movable m2 = (Movable)regionableList.get(j);
                        checkCollision(m1, m2);
                    }
                }
            }
        }
    }

    private void checkCollision(Movable m1, Movable m2) {
        if (m1.getBounds().intersects(m2.getBounds())){
            if (m2.getMinX() < m1.getMinX()  && m1.getMinX() < m2.getMaxX()
                || m2.getMinX() < m1.getMaxX() && m1.getMaxX() < m2.getMaxX()) {
                m2.setDx(-m2.getDx());
                m1.setDx(-m1.getDx());
            }
    
            if (m2.getMaxY() > m1.getMinY() && m1.getMinY() > m2.getMinY()
                || m2.getMaxY() > m1.getMaxY() && m1.getMaxY() > m2.getMinY()) {
                m2.setDy(-m2.getDy());
                m1.setDy(-m1.getDy());
            }

            m1.move();
            plusMoveCount();
            m2.move();
            plusMoveCount();
            repaint();
        }
    }

    private void checkOutOfbounds(Movable m) {
        if (m.getMinX() < getBounds().getMinX()) {
            m.setDx(-m.getDx());
            m.moveTo((int)getBounds().getMinX() + m.getWidth()/2, m.getY());
        }
        
        if ( m.getMaxX() > getBounds().getMaxX()) {
            m.setDx(-m.getDx());
            m.moveTo((int)getBounds().getMaxX() - m.getWidth()/2, m.getY());
        }

        if (m.getMinY() < getBounds().getMinY()){
            m.setDy(-m.getDy());
            m.moveTo(m.getX(), (int)getBounds().getMinY() + m.getHeight());
        }
        
        if (m.getMaxY() > getBounds().getMaxY()) {
            m.setDy(-m.getDy());
            m.moveTo(m.getX(), (int)getBounds().getMaxY() - m.getHeight());
        }   
    }

}
