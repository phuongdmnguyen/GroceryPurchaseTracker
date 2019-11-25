package gui.groceriesitemtools;

import gui.GroceryPanel;

import javax.swing.*;

public class CalculateTripTool extends Tool {

    public CalculateTripTool(GroceryPanel panel, JComponent parent) {
        super(panel,parent);
        button.setActionCommand("calculatetrip");
    }

    @Override
    protected String getLabel() {
        return "Calculate Trip";
    }
}
