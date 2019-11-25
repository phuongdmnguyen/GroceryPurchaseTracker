package gui.personalsettingstools;

import gui.PersonalSettingsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MustHaveTool implements ActionListener {

    protected static PersonalSettingsPanel personalSettingsPanel;
    protected JButton button;

    public MustHaveTool(PersonalSettingsPanel panel, JComponent parent) {
        this.personalSettingsPanel = panel;
        createButton();
        addToParent(parent);
        button.addActionListener(this);
    }

    private void addToParent(JComponent parent) {
        parent.add(button);
    }

    protected void createButton() {
        button = new JButton("Add must have item");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String iname = JOptionPane.showInputDialog("Input item's name");
        personalSettingsPanel.addNewMH(iname);
        personalSettingsPanel.addNewMustHaveToTable(iname);
    }
}
