package gui;

import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class AppPanel extends JPanel {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private JTabbedPane tabbedPane;

    public AppPanel() throws IOException, JSONException {
        super(new GridLayout(1, 1));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.GRAY);
        createFunctionPanels();
    }

    private void createFunctionPanels() throws IOException, JSONException {
        tabbedPane = new JTabbedPane();

        PersonalSettingsPanel personalSettingsPanel = new PersonalSettingsPanel();
        tabbedPane.addTab(personalSettingsPanel.getTitle(), null, personalSettingsPanel,
                "Set your personal budget and must have items");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);


        GroceryPanel groceryPanel = new GroceryPanel();
        tabbedPane.addTab(groceryPanel.getTitle(), null, groceryPanel,
                "Add a grocery trip");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);


        NetworkPanel networkPanel = new NetworkPanel();
        tabbedPane.addTab(networkPanel.getTitle(), null, networkPanel,
                "find recipes from online database");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        //Add the tabbed pane to this panel.
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }


    private static void createAndShowGUI() throws IOException, JSONException {
        //Create and set up the window.
        JFrame frame = new JFrame("Grocery Budget Tracker");
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new AppPanel(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                try {
                    createAndShowGUI();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


