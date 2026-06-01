package com.jmarlon.tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CircleTool implements DrawingTool {

    private Point start;
    private Point current;

    private Color color = Color.BLACK;

    private List<Point[]> circles = new ArrayList<>();

    @Override
    public void onPress(MouseEvent e) {
        start = e.getPoint();
        current = e.getPoint();
    }

    @Override
    public void onDrag(MouseEvent e, Graphics g) {
        current = e.getPoint();
    }

    @Override
    public void onRelease(MouseEvent e) {
        if (start != null) {
            circles.add(new Point[]{start, e.getPoint()});
            start = null;
            current = null;
        }
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(color);

        for (Point[] points : circles) {
            int x0 = points[0].x;
            int y0 = points[0].y;

            int x1 = points[1].x;
            int y1 = points[1].y;

            g.drawOval(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x0 - x1), Math.abs(y0 - y1));
        }

        if (start != null && current != null) {
            int x0 = start.x;
            int y0 = start.y;

            int x1 = current.x;
            int y1 = current.y;

            g.drawOval(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x0 - x1), Math.abs(y0 - y1));
        }

    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

}
