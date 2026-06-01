package com.jmarlon.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonComponent extends JButton {

    public ButtonComponent(String path, String description) {
        this.setIcon(createImageIcon(path, description));
        this.setToolTipText(description);
    }

    private static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = ButtonComponent.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
