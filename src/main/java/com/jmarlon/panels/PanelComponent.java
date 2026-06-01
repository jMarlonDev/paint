package com.jmarlon.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelComponent extends JPanel {

    public PanelComponent(Color colorPanel, int width, int height) {
        this.setBackground(colorPanel);
        this.setPreferredSize(new Dimension(width, height));
    }
}
