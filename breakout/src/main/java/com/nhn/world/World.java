package com.nhn.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.nhn.ball.Ball;
import com.nhn.ball.PaintableBall;
import com.nhn.exception.OutOfBoundsException;

public class World extends JPanel{
    private List<Ball> ballList;

    public World() {
        ballList = new ArrayList<>();
    }

    public void add(Ball ball) {
        if (isOutOfBounds(ball)) {
            throw new OutOfBoundsException();
        }

        ballList.add(ball);
        System.out.println("ball added world : " + ball);
        repaint();
    }
    
    public void remove(Ball ball) {
        ballList.remove(ball);
        repaint();
    }
    
    public void remove(int index) {
        ballList.remove(index);
        repaint();
    }
    
    public int getCount() {
        return ballList.size();
    }
    
    public Ball get(int index) {
        return ballList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall)ball).paint(g);
            }
        }
    }

    private boolean isOutOfBounds(Ball ball) {
        return ball.getX() - ball.getRadius() < 0 || ball.getY() - ball.getRadius() < 0
                || ball.getX() + ball.getRadius() > getWidth() || ball.getY() + ball.getRadius() > getHeight(); 
    }
}
