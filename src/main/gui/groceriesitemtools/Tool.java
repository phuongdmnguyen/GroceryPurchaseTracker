package gui.groceriesitemtools;

import gui.GroceryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Tool {

    protected static GroceryPanel groceryPanel;
    protected JButton button;
    private boolean active;

    public Tool(GroceryPanel panel, JComponent parent) {
        this.groceryPanel = panel;
        createButton();
        active = false;
        addToParent(parent);
        button.addActionListener(new ToolHandler());
    }

    private void addToParent(JComponent parent) {
        parent.add(button);
    }

    protected void createButton() {
        button = new JButton(getLabel());
    }

    protected abstract String getLabel();

    protected void setActive() {
        active = true;
    }

    private class ToolHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("calculatetrip")) {
                int sum = groceryPanel.getGroceryList().getTotalCost();
                JOptionPane.showMessageDialog(groceryPanel,"The total cost of your trip is " + sum);
            } else if (command.equals("meat")) {
                MeatTool.addMeat();
            } else if (command.equals("grocery")) {
                GroceryTool.addGrocery();
            }  else if (command.equals("household")) {
                HouseholdTool.addHousehold();
            }   else if (command.equals("produce")) {
                ProduceTool.addProduce();
            }
        }
    }
}

