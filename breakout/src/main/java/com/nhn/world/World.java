package com.nhn.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.nhn.ball.Ball;
import com.nhn.ball.PaintableBall;

public class World extends JPanel{
    private List<Ball> ballList;

    public World() {
        ballList = new ArrayList<>();
    }

    public void add(Ball ball) {
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
                if (isPaintable((PaintableBall)ball)){
                    ((PaintableBall)ball).paint(g);
                } else {
                    System.out.println("world의 영역에 속하지 않음");
                }
            }
        }
    }

    private boolean isPaintable(PaintableBall ball) {
        return ball.getX() - ball.getRadius() >= 0 && ball.getY() - ball.getRadius() >= 0
                && ball.getX() + ball.getRadius() <= getWidth() && ball.getY() + ball.getRadius() <= getHeight(); 
    }
}
