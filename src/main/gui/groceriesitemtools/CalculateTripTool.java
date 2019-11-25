package gui.groceriesitemtools;

import gui.GroceryPanel;

import javax.swing.*;
import java.awt.*;

public class CalculateTripTool extends Tool {
    static final ClassLoader loader = gui.groceriesitemtools.CalculateTripTool.class.getClassLoader();


    public CalculateTripTool(GroceryPanel panel, JComponent parent) {
        super(panel,parent);
        button.setActionCommand("calculatetrip");
        ImageIcon icon = createScaledImageIcon("calculator.png");
        button.setIcon(icon);
    }

    protected static ImageIcon createScaledImageIcon(String path) {
//        java.net.URL imgURL = Tool.class.getResource(path);
        java.net.URL imgURL = loader.getResource(path);
        ImageIcon img;
        img = new ImageIcon(imgURL);
        Image newimg = img.getImage().getScaledInstance(ICON_WIDTH,ICON_HEIGHT, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    @Override
    protected String getLabel() {
        return "Calculate Trip";
    }
}
