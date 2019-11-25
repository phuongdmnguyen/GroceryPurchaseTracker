package gui;

import model.GroceriesList;
import model.ShoppingListMonitor;

import javax.swing.*;
import java.awt.*;

public abstract class Panel extends JPanel {
    JPanel panel;
    String title;
    protected static GroceriesList groceriesList;
    protected ShoppingListMonitor shoppingListMonitor;


    public Panel() {
        super(new GridLayout(1,1));
        makeTextPanel();
        title = "";
        shoppingListMonitor = new ShoppingListMonitor();
        groceriesList = new GroceriesList(shoppingListMonitor);
    }

    protected JComponent makeTextPanel() {
        panel = new JPanel(false);
//        JLabel filler = new JLabel(getLabel());
//        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
//        panel.add(filler);
        return panel;
    }

    protected abstract String getTitle();
}
