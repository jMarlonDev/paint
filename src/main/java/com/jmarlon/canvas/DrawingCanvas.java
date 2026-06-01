package com.jmarlon.canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import com.jmarlon.tools.DrawingTool;
import com.jmarlon.tools.PencilTool;

public class DrawingCanvas extends JPanel {

    private DrawingTool currentTool = new PencilTool();
    private Color currentColor = Color.black;

    public void setTool(DrawingTool tool) {
        this.currentTool = tool;
    }

    public DrawingCanvas() {
        this.setLayout(null);
        this.setBackground(Color.white);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentTool.onPress(e);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentTool.onRelease(e);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentTool.onDrag(e, getGraphics());
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentTool.paint(g);
    }

    public Color getCurrentColor() {
        return this.currentColor;
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }
}

/*
   DrawingCanvas: Extiende de JPanel así que tiene todas las funcionalidades y propiedades
   del JPanel de java swing, este simula el lienzo de dibujo
   
   addMouseListener(): Agrega al Panel un adaptador que se encarga de controlar 
   los eventos que vienen de la interacción con el mouse proporcionando todos sus métodos 
   vacíos para agregar nueva funcionalidad

   mousePressed(): Se activa cuando se da click con el mouse por primera vez se encarga 
   de obtener y almacenar el punto inicial donde se dio click en el panel
   este punto se le pasa como parametro a cada herramienta de dibujo que se vaya 
   a ejecutar

   mouseReleased(): Se activa cuando se suelta el click con el mouse y este lo que hace es que 
   se encarga de obtener y almacenar el punto final es decir el ultimo punto donde se hizo click 
   con el mouse y se lo pasa como parametro a la herramienta que se este ejecutando

   mouseDragged(): Es el evento encargado de registrar y actualizar constantemente
   los puntos por donde pasa el mouse al ser arrastrado con el click
   así este evento se activa mientras arrastramos el mouse con toda la trayectoria
   hasta que se suelta el click
 */
