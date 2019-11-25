package gui.personalsettingstools;

import gui.GroceryPanel;
import gui.PersonalSettingsPanel;
import model.exceptions.BudgetReachedException;
import model.exceptions.NoBudgetException;
import ui.GroceryTripSettings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TripSufficientTool implements ActionListener {
    protected static PersonalSettingsPanel personalSettingsPanel;
    protected JButton button;

    public TripSufficientTool(PersonalSettingsPanel panel, JComponent parent) {
        this.personalSettingsPanel = panel;
        createButton();
        addToParent(parent);
        button.addActionListener(this);
    }

    private void addToParent(JComponent parent) {
        parent.add(button);
    }

    protected void createButton() {
        button = new JButton("Check trip sufficient?");
    }

    private String shoppingListMessage() {
        return "You need to buy these items: ";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            personalSettingsPanel.getGroceryList().isContainMustHaves(personalSettingsPanel.getMustHaveList());
            JOptionPane.showMessageDialog(personalSettingsPanel,
                    shoppingListMessage() + personalSettingsPanel.getGroceryList().getShoppingList());
        } catch (BudgetReachedException ex) {
            JOptionPane.showMessageDialog(personalSettingsPanel,"There is some budget issues");
        } catch (NoBudgetException ex) {
            JOptionPane.showMessageDialog(personalSettingsPanel,"Please set budget before proceeding");
        }

    }
}
