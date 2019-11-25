package gui;

import gui.personalsettingstools.BudgetTool;
import gui.personalsettingstools.MustHaveTool;
import gui.personalsettingstools.TripSufficientTool;
import model.GroceriesList;
import model.MustHaveList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class PersonalSettingsPanel extends Panel {
    protected MustHaveList mustHaveList;
    protected JTable mustHaves;
    protected DefaultTableModel model;
    protected Object[][] data;
    protected String[] columnNames = {"Item"};
    private JLabel budgetLabel;

    public PersonalSettingsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = "Personal Settings";
        setPreferredSize(new Dimension(300, 400));
        intializeTable();
        initializeTools();
        budgetLabel = new JLabel("");
        add(budgetLabel);
        mustHaveList = new MustHaveList();
    }

    private void intializeTable() {
        data = new String[][]{};
//        groceryTrip = new JTable(data, columnNames);
        model = new DefaultTableModel(data, columnNames);
        mustHaves = new JTable(model);
        add(new JScrollPane(mustHaves));
    }

    public void budget(int b) {
        groceriesList.setBudget(b);
    }

    public GroceriesList getGroceryList() {
        return groceriesList;
    }

    public MustHaveList getMustHaveList() {
        return mustHaveList;
    }

    public void addNewMustHaveToTable(String iname) {
        model.addRow(new String[]{iname});
    }

    public void addNewMH(String i) {
        mustHaveList.addItemToMHList(i);
    }

    private void initializeTools() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(0,1));
        toolArea.setSize(new Dimension(0, 0));
        add(toolArea, BOTTOM_ALIGNMENT);

        BudgetTool budgetTool = new BudgetTool(this,toolArea);
        MustHaveTool mustHaveTool = new MustHaveTool(this, toolArea);
        TripSufficientTool tripSufficientTool = new TripSufficientTool(this,toolArea);
        JOptionPane.showMessageDialog(this, getGroceryList().getShoppingList());

    }

    @Override
    protected String getTitle() {
        return title;
    }
}
