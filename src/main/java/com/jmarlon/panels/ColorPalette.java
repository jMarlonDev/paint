package com.jmarlon.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColorPalette extends JPanel {

    private JColorChooser colorChooser;

    public ColorPalette() {

        this.setLayout(new BorderLayout());

        this.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));

        colorChooser = new JColorChooser();

        AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();

        for (int i = 1; i < panels.length; i++) {
            colorChooser.removeChooserPanel(panels[i]);
        }

        colorChooser.setPreviewPanel(new JPanel());

        colorChooser.setBorder(BorderFactory.createEmptyBorder());

        colorChooser.setPreferredSize(new Dimension(500, 100));

        this.add(colorChooser, BorderLayout.WEST);
    }

    public JColorChooser getColorChooser() {
        return colorChooser;
    }
}

/*

    JColorChooser es un selector de color 
    que permite usar java swing de forma nativa 
    pero el componente en sí viene con paneles internos
    que representan diferentes estilos de colores 
    como:

    Paleta de colores simple,
    HSB, RGB, CMYK

    AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();

    Este me da una arreglo con todas los paneles de colores que
    tiene por defecto el JColorChooser

    Entonces se recorre el arreglo empezando desde 1 
    por que en la posición cero se encuentra solo la paleta de colores simples 
    que es la unica que se va a usar en el lienzo principal
    Con la clase Abstract me permite solo usar esa paleta de colores 
    y eliminar las otras:

    panels[0] = Swatches paleta de colores
    panels[1] = HSV
    panels[2] = HSL
    panels[3] = RGB
    panels[4] = CMYK

 */
