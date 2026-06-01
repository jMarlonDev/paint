package com.jmarlon.toolbar;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.jmarlon.buttons.ButtonComponent;
import com.jmarlon.canvas.DrawingCanvas;
import com.jmarlon.tools.CircleTool;
import com.jmarlon.tools.EraserTool;
import com.jmarlon.tools.LineTool;
import com.jmarlon.tools.PencilTool;
import com.jmarlon.tools.RectangleTool;
import com.jmarlon.tools.TextTool;

public class ToolBar extends JPanel {

    public ToolBar(DrawingCanvas canvas) {
        this.setLayout(new GridLayout(3, 3, 4, 4));

        // Herramientas de dibujo
        PencilTool pencilTool = new PencilTool();
        LineTool lineTool = new LineTool();
        RectangleTool rectangleTool = new RectangleTool();
        CircleTool circleTool = new CircleTool();
        TextTool textTool = new TextTool(canvas);
        EraserTool eraserTool = new EraserTool();

        // Botones de acción
        ButtonComponent pencilBtn = new ButtonComponent("/icons/pencil.png", "Pencil");
        ButtonComponent lineBtn = new ButtonComponent("/icons/line.png", "Line");
        ButtonComponent rectangleBtn = new ButtonComponent("/icons/rectangle.png", "Rectangle");
        ButtonComponent circleBtn = new ButtonComponent("/icons/circle.png", "Circle");
        ButtonComponent textBtn = new ButtonComponent("/icons/text.png", "Text");
        ButtonComponent eraserBtn = new ButtonComponent("/icons/eraser.png", "Eraser");

        // Evento para cada boton
        pencilBtn.addActionListener(e -> {

            pencilTool.setColor(
                    canvas.getCurrentColor()
            );

            canvas.setTool(pencilTool);
        });

        this.add(pencilBtn);

        lineBtn.addActionListener(e -> {

            lineTool.setColor(
                    canvas.getCurrentColor()
            );

            canvas.setTool(lineTool);
        });

        this.add(lineBtn);

        rectangleBtn.addActionListener(e -> {

            rectangleTool.setColor(
                    canvas.getCurrentColor()
            );

            canvas.setTool(rectangleTool);
        });

        this.add(rectangleBtn);

        circleBtn.addActionListener(e -> {

            circleTool.setColor(
                    canvas.getCurrentColor()
            );

            canvas.setTool(circleTool);
        });

        this.add(circleBtn);

        textBtn.addActionListener(e -> {

            textTool.setColor(
                    canvas.getCurrentColor()
            );

            canvas.setTool(textTool);
        });

        this.add(textBtn);

        eraserBtn.addActionListener(e -> {

            canvas.setTool(eraserTool);
        });

        this.add(eraserBtn);
    }

}
