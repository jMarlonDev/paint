package com.jmarlon.tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class EraserTool implements DrawingTool {

    private Point[] points = new Point[10000];

    private int pointCounter = 0;

    // Posición actual del mouse
    private Point current;

    // Tamaño del borrador
    private final int SIZE = 30;

    @Override
    public void onPress(MouseEvent e) {

        current = e.getPoint();
    }

    @Override
    public void onDrag(MouseEvent e, Graphics g) {

        current = e.getPoint();

        if (pointCounter < points.length) {

            points[pointCounter] = e.getPoint();

            pointCounter++;
        }
    }

    @Override
    public void onRelease(MouseEvent e) {

        current = null;
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.WHITE);

        for (int i = 0; i < pointCounter; i++) {

            g.fillOval(
                    points[i].x - SIZE / 2,
                    points[i].y - SIZE / 2,
                    SIZE,
                    SIZE
            );
        }

        if (current != null) {

            g.setColor(Color.GRAY);

            g.drawOval(
                    current.x - SIZE / 2,
                    current.y - SIZE / 2,
                    SIZE,
                    SIZE
            );
        }
    }

    @Override
    public void setColor(Color color) {
    }
}
