package com.jmarlon.tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public interface DrawingTool {

    void onPress(MouseEvent e);

    void onDrag(MouseEvent e, Graphics g);

    void onRelease(MouseEvent e);

    public void paint(Graphics g);

    void setColor(Color color);
}


/*
    onPress(): Se activa al dar click con el mouse
    obtiene el punto donde se hizó click y lo guarda como el punto inicial
    
    onDrag(): Se activa al arrastrar el mouse con el click sostenido
    se actualiza constantemente obteniendo y guardando cada punto nuevo 
    por donde se mueve el mouse

    onRelease(): Se activa al soltar el click y dejar de arrastrar el mouse
    guarda y obtiene el ultimo punto o punto final de todo el trayecto que hizo el mouse

    paint(): Método que se llama cada vez que se hace repaint() y actualiza y redibuja el contenido 
    y muestra el dibujo
 */
