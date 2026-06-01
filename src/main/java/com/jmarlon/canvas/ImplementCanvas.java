package com.jmarlon.canvas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class ImplementCanvas extends JPanel {

    private DrawingCanvas canvas;

    public ImplementCanvas() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.gray);

        canvas = new DrawingCanvas();

        GridBagConstraints rules = new GridBagConstraints();

        rules.gridx = 0;
        rules.gridy = 0;
        rules.weightx = 1.0;
        rules.weighty = 1.0;
        rules.fill = GridBagConstraints.BOTH;
        rules.insets = new Insets(0, 5, 5, 5);

        this.add(canvas, rules);
    }

    public DrawingCanvas getCanvas() {
        return canvas;
    }
}
