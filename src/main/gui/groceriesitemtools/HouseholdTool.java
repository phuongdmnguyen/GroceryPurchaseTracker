package gui.groceriesitemtools;

import gui.GroceryPanel;
import model.items.Item;
import model.items.HouseholdItem;

import javax.swing.*;

public class HouseholdTool extends Tool {

    public HouseholdTool(GroceryPanel panel, JComponent parent) {
        super(panel, parent);
        button.setActionCommand("household");
    }

    public static void addHousehold() {
        String iname = JOptionPane.showInputDialog("Input item's name");
        String icost = JOptionPane.showInputDialog("Input item's cost");
        double cost = Double.parseDouble(icost);
        String iquantity = JOptionPane.showInputDialog("Input item's quantity");
        int quantity = Integer.parseInt(iquantity);
        Item item = new HouseholdItem(iname);
        itemSetUpAndUpdate(cost, quantity, item);
        groceryPanel.add(icost,iquantity,iname);

    }

    public static void itemSetUpAndUpdate(double icost, int iquantity, Item item) {
        item.setCost(icost);
        item.setQuantity(iquantity);
        groceryPanel.getGroceryList().addItem(item);
    }



    @Override
    protected String getLabel() {
        return "Household Item";
    }
}
