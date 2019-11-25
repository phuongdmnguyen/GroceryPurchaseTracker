package gui;

import model.MustHaveList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalSettingsPanel extends Panel {
    private int budget;
    protected MustHaveList mustHaveList;
    protected JTable mustHaves;
    protected DefaultTableModel model;
    protected Object[][] data;
    protected String[] columnNames = {"Item"};
    private JLabel budgetLabel;

    public PersonalSettingsPanel() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        title = "Personal Settings";
        setPreferredSize(new Dimension(300,400));
        intializeTable();
        setBudget();
        budgetLabel = new JLabel("");
        add(budgetLabel);
        mustHaveList = new MustHaveList();
    }

    private void intializeTable() {
        data = new String[][]{};
//        groceryTrip = new JTable(data, columnNames);
        model = new DefaultTableModel(data,columnNames);
        mustHaves = new JTable(model);
        add(new JScrollPane(mustHaves));
    }

    private void setBudget() {
        JButton budgetButton = new JButton("Set budget");
        budgetButton.setPreferredSize(new Dimension(100,100));
        add(budgetButton, BOTTOM_ALIGNMENT);
        budgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uibudget = JOptionPane.showInputDialog("Input your budget");
                budget = Integer.parseInt(uibudget);
                budgetLabel.setText("My budget is: " + budget);

            }
        });

    }

    @Override
    protected String getTitle() {
        return title;
    }
}
