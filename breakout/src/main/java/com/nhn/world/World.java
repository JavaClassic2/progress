package com.nhn.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.nhn.exception.OutOfBoundsException;
import com.nhn.object.Paintable;
import com.nhn.object.Regionable;

public class World extends JPanel{
    private List<Regionable> RegionableList;

    public World() {
        RegionableList = new ArrayList<>();
    }

    public void add(Regionable regionable) {
        if (isOutOfBounds(regionable)) {
            throw new OutOfBoundsException();
        }

        RegionableList.add(regionable);
        System.out.println(regionable.getClass().getName() +" added world : " + regionable);
        repaint();
    }
    
    public void remove(Regionable regionable) {
        RegionableList.remove(regionable);
        repaint();
    }
    
    public void remove(int index) {
        RegionableList.remove(index);
        repaint();
    }
    
    public int getCount() {
        return RegionableList.size();
    }
    
    public Regionable get(int index) {
        return RegionableList.get(index);
    }

    public List<Regionable> getRegionableList() {
        return RegionableList;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Regionable regionable : RegionableList) {
            if (regionable instanceof Paintable) {
                ((Paintable)regionable).paint(g);
            }
        }
    }

    private boolean isOutOfBounds(Regionable bounded) {
        return bounded.getMinX() < 0 || bounded.getMinY() < 0
                || bounded.getMaxX() > getWidth() || bounded.getMaxY() > getHeight(); 
    }
}
