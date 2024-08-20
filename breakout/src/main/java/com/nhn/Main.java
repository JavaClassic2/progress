package com.nhn;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhn.ball.MovableBall;
import com.nhn.brick.Bar;
import com.nhn.brick.Brick;
import com.nhn.world.BoundedWorld;

public class Main {
    static Random random = new Random();
    static final Color[] colors = {Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PINK, Color.GREEN};
    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 300;

    private static JFrame frame;
    private static BoundedWorld world;
    private static Bar bar;

    public static void main(String[] args) {
        prepare();

        addEvent();

        world.run();
    }

    private static void prepare() {
        frame = new JFrame();
        world = new BoundedWorld();

        frame.add(world);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        bar = new Bar(world.getWidth()/2, FRAME_HEIGHT * 3/4, FRAME_WIDTH/5, FRAME_HEIGHT/20);
        world.add(bar);

        MovableBall powerBall = new MovableBall(FRAME_WIDTH/2, FRAME_HEIGHT/2, 10, Color.PINK, 5, 4);
        world.add(powerBall);

        int brickWidth = FRAME_WIDTH / 10;
        int brickHeight = FRAME_HEIGHT / 10;

        for (int y=0; y<2; y++){
            for (int x=0; x<9; x++) {
                Brick brick = new Brick(brickWidth/2 + x * brickWidth, brickHeight/2 + brickHeight*y, brickWidth-10, brickHeight-10);
                world.add(brick);
            }
        }
    }

    private static void addEvent() {
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                bar.moveTo(e.getX() - bar.getWidth()/2, bar.getY());
                world.repaint();
            }    
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    bar.moveTo(bar.getX()-10, bar.getY());
                    world.repaint();
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    bar.moveTo(bar.getX()+10, bar.getY());
                    world.repaint();
                }
            }
        });
    }
}
