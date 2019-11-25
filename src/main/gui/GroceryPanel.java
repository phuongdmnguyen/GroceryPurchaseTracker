package gui;

import gui.groceriesitemtools.*;
import model.GroceriesList;
import model.ShoppingListMonitor;
import model.items.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GroceryPanel extends Panel {
    protected JTable groceryTrip;
    protected DefaultTableModel model;
    protected Object[][] data;
    protected String[] columnNames = {"Item", "Cost", "Quantity"};
    protected GroceriesList groceriesList;


    public GroceryPanel() {
        ShoppingListMonitor shoppingListMonitor = new ShoppingListMonitor();
        groceriesList = new GroceriesList(shoppingListMonitor);
        title = "Grocery";
        initiatlizeData();
        intializeTools();
    }

    public GroceriesList getGroceryList() {
        return groceriesList;
    }

    private void intializeTools() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(0,1));
        toolArea.setSize(new Dimension(0, 0));
        add(toolArea, BorderLayout.AFTER_LAST_LINE);

        GroceryTool groceryTool = new GroceryTool(this, toolArea);
        HouseholdTool householdItemTool = new HouseholdTool(this,toolArea);
        MeatTool meatTool = new MeatTool(this,toolArea);
        ProduceTool produceTool = new ProduceTool(this,toolArea);
        CalculateTripTool calculateTripTool = new CalculateTripTool(this,toolArea);
    }

    private void initiatlizeData() {
        data = new String[][]{};
//        groceryTrip = new JTable(data, columnNames);
        model = new DefaultTableModel(data,columnNames);
        groceryTrip = new JTable(model);
        add(new JScrollPane(groceryTrip));
    }

    public void add(String icost, String iquantity, String iname) {
        model.addRow(new String[]{iname, icost, iquantity});
    }

    @Override
    protected String getTitle() {
        return title;
    }
}
