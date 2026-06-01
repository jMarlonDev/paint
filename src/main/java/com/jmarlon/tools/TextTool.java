package com.jmarlon.tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jmarlon.canvas.DrawingCanvas;

public class TextTool implements DrawingTool {

    private Point start;
    private Point current;

    private DrawingCanvas canvas;

    private Color color = Color.BLACK;

    public TextTool(DrawingCanvas canvas) {
        this.canvas = canvas;
    }

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

        if (start == null) {
            return;
        }

        int x = Math.min(start.x, e.getX());
        int y = Math.min(start.y, e.getY());

        int width = Math.abs(start.x - e.getX());
        int height = Math.abs(start.y - e.getY());

        JTextArea textArea = new JTextArea();
        textArea.setForeground(color);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBounds(x, y, width, height);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        canvas.add(scrollPane);

        textArea.requestFocusInWindow();

        canvas.repaint();

        start = null;
        current = null;
    }

    @Override
    public void paint(Graphics g) {

        if (start != null && current != null) {

            int x = Math.min(start.x, current.x);
            int y = Math.min(start.y, current.y);

            int width = Math.abs(start.x - current.x);
            int height = Math.abs(start.y - current.y);

            g.drawRect(x, y, width, height);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
