package gui.groceriesitemtools;

import gui.GroceryPanel;
import model.items.Item;
import model.items.Meat;

import javax.swing.*;

public class MeatTool extends Tool {

    public MeatTool(GroceryPanel panel, JComponent parent) {
        super(panel, parent);
        button.setActionCommand("meat");
    }

    @Override
    protected String getLabel() {
        return "Meat";
    }


    public static void addMeat() {
        String iname = JOptionPane.showInputDialog("Input item's name");
        String icost = JOptionPane.showInputDialog("Input item's cost");
        double cost = Double.parseDouble(icost);
        String iquantity = JOptionPane.showInputDialog("Input item's quantity");
        int quantity = Integer.parseInt(iquantity);
        Item item = new Meat(iname);
        itemSetUpAndUpdate(cost, quantity, item);
        groceryPanel.add(icost,iquantity,iname);
    }

    public static void itemSetUpAndUpdate(double icost, int iquantity, Item item) {
        item.setCost(icost);
        item.setQuantity(iquantity);
        groceryPanel.getGroceryList().addItem(item);
    }

}
