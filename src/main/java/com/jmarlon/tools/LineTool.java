package com.jmarlon.tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class LineTool implements DrawingTool {

    private Point start;
    private Point current;
    private Color color = Color.BLACK;

    private List<Point[]> lines = new ArrayList<>();

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
            lines.add(new Point[]{start, e.getPoint()});
            start = null;
            current = null;
        }
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(color);
        // Dibuja la linea basado en los puntos guardados en el arreglo
        for (Point[] line : lines) {
            g.drawLine(line[0].x, line[0].y, line[1].x, line[1].y);
        }

        // Muestra la linea en progreso en tiempo real cuando se arrastra el mouse haciendo click
        if (start != null && current != null) {
            g.drawLine(start.x, start.y, current.x, current.y);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}

/*
    private Point start;
    private Point current;

    start: se encarga de almacenar y obtener el punto inicial 
    cuando se dio click por primera vez en alguna parte del panel

    current: se encarga de almacenar y obtener el valor actual donde se 
    encuentra el punto en el panel actualmente este se actualiza constantemente
    mientras se arrastra el mouse haciendo click 
    esta variable obtiene cada punto que recorre el mouse 
    en el panel

 
    private List<Point[]> lines = new ArrayList<>();

    Esta es una lista donde cada elemento es un arreglo de 2 puntos Point[]
    y cada Point[] tiene exactamente 2 posiciones:

    [0] → punto de inicio (donde se hizo click por primera vez)
    [1] → punto final (donde se solto por ultima vez)

    onPress(): Se activa cuando se hace click por primera vez con el mouse
    y luego inicializa:

    start: almacena el punto inicial donde se hizo click

    current: comienza en el mismo punto que start pero esta variable 
    se va a ir actualizando constantemente mientras se arrastra el mouse 
    haciendo click


    onDrag(): Se activa cuando se arrastra el mouse haciendo click
    y lo único que hace es actualizar el valor 
    de la variable current con cada punto que se va obteniendo 
    durante el recorrido del arrastre con el mouse

    onRelease(): Se activa cuando se suelta el click del mouse 
    y obtiene el punto final de todo el recorrido hecho por el mouse

    verifica: Primero que antes de que haya un punto final 
    primero se haya un punto inicial para evitar errores de dibujo 

    si existe ese punto inicial entonces
    se agrega a la lista  un arreglo que va a tener dos puntos 

    arreglo agregado a la lista

    Point[]{start, e.getPoint()} 
    Primer punto el anterior que se obtuvo con el evento onPress()
    y el ultimo punto cuando se solto el click del mouse 
    para asi obtener el recorrido completo que se hizo 

    paint():
    Este es el método mas importante ya que es el encargado 
    de dibujar cada linea que este guardada en la lista

    Primero: recorre la lista con los subarreglos que contienen dos puntos

    el drawLine(): 
    recibe x0, y0 como punto inicial 
    x1, y1 como punto final para poder dibujar la linea en el panel con todo su recorrido

 */
