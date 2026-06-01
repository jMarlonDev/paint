package com.jmarlon.tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class PencilTool implements DrawingTool {

    private Point[] points = new Point[10000];
    private int pointCounter = 0;
    private Color color = Color.BLACK;

    @Override
    public void onPress(MouseEvent e) {
    }

    @Override
    public void onDrag(MouseEvent e, Graphics g) {
        if (pointCounter < points.length) {
            points[pointCounter] = e.getPoint();
            pointCounter++;
        }
    }

    @Override
    public void onRelease(MouseEvent e) {
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        for (int i = 0; i < pointCounter; i++) {
            g.fillOval(points[i].x, points[i].y, 10, 10);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
