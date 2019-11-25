package gui.groceriesitemtools;

import gui.GroceryPanel;
import model.items.Item;
import model.items.HouseholdItem;

import javax.swing.*;
import java.awt.*;

public class HouseholdTool extends Tool {
    static final ClassLoader loader = gui.groceriesitemtools.GroceryTool.class.getClassLoader();


    public HouseholdTool(GroceryPanel panel, JComponent parent) {
        super(panel, parent);
        button.setActionCommand("household");
        ImageIcon icon = createScaledImageIcon("household.jpg");
        button.setIcon(icon);
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
        return "Household Item";
    }
}
