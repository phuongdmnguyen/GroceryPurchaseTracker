package gui.personalsettingstools;

import gui.PersonalSettingsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetTool implements ActionListener {

    protected static PersonalSettingsPanel personalSettingsPanel;
    protected JButton button;

    public BudgetTool(PersonalSettingsPanel panel, JComponent parent) {
        this.personalSettingsPanel = panel;
        createButton();
        addToParent(parent);
        button.addActionListener(this);
    }

    private void addToParent(JComponent parent) {
        parent.add(button);
    }

    protected void createButton() {
        button = new JButton("Set Budget");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String uibudget = JOptionPane.showInputDialog("Input your budget");
        int b = Integer.parseInt(uibudget);
        personalSettingsPanel.budget(b);
    }
}
