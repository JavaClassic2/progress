package com.nhn.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.nhn.ball.PaintableBall;
import com.nhn.exception.OutOfBoundsException;
import com.nhn.object.Regionable;

public class World extends JPanel{
    private List<Regionable> boundedList;

    public World() {
        boundedList = new ArrayList<>();
    }

    public void add(Regionable ball) {
        if (isOutOfBounds(ball)) {
            throw new OutOfBoundsException();
        }

        boundedList.add(ball);
        System.out.println("ball added world : " + ball);
        repaint();
    }
    
    public void remove(Regionable ball) {
        boundedList.remove(ball);
        repaint();
    }
    
    public void remove(int index) {
        boundedList.remove(index);
        repaint();
    }
    
    public int getCount() {
        return boundedList.size();
    }
    
    public Regionable get(int index) {
        return boundedList.get(index);
    }

    public List<Regionable> getBoundedList() {
        return boundedList;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Regionable b : boundedList) {
            if (b instanceof PaintableBall) {
                ((PaintableBall)b).paint(g);
            }
        }
    }

    private boolean isOutOfBounds(Regionable bounded) {
        return bounded.getMinX() < 0 || bounded.getMinY() < 0
                || bounded.getMaxX() > getWidth() || bounded.getMaxY() > getHeight(); 
    }
}
