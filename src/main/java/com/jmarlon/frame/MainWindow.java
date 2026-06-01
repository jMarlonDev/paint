package com.jmarlon.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jmarlon.canvas.ImplementCanvas;
import com.jmarlon.panels.ColorPalette;
import com.jmarlon.panels.PanelComponent;
import com.jmarlon.toolbar.ToolBar;

public class MainWindow extends JFrame {

    public MainWindow() {
        this.setTitle("PAINT");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        PanelComponent top = new PanelComponent(Color.gray, 0, 15);
        ImplementCanvas implementCanvas = new ImplementCanvas();
        ToolBar toolBar = new ToolBar(implementCanvas.getCanvas());

        JPanel left = new JPanel();
        left.add(toolBar);

        ColorPalette colorPalette = new ColorPalette();

        colorPalette.getColorChooser().getSelectionModel().addChangeListener(e -> {

            Color selectedColor = colorPalette.getColorChooser().getColor();
            implementCanvas.getCanvas().setCurrentColor(selectedColor);

        });

        this.add(top, BorderLayout.NORTH);
        this.add(colorPalette, BorderLayout.SOUTH);
        this.add(left, BorderLayout.WEST);
        this.add(implementCanvas, BorderLayout.CENTER);
        this.setSize(1300, 700);
        this.setVisible(true);
    }
}
