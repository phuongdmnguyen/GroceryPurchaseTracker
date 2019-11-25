package gui.networktools;

import gui.NetworkPanel;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Tool implements ActionListener {

    protected static NetworkPanel networkPanel;
    protected JButton button;
    static final ClassLoader loader = Tool.class.getClassLoader();


    public Tool(NetworkPanel panel, JComponent parent) throws IOException {
        networkPanel = panel;
        createButton();
        addToParent(parent);
        button.addActionListener(this);
    }

    private void addToParent(JComponent parent) {
        parent.add(button);
    }

    protected void createButton() throws IOException {
        ImageIcon icon = createScaledImageIcon("recipe1.jpg");
        button = new JButton(icon);
        button.setBackground(Color.WHITE);
        button.setPreferredSize(new Dimension(100,100));
    }

    //REQUIRES: user input
    //EFFECTS: read api url and obtain recipes from userinput prompts
    public void readSource() throws IOException {
////        String url = "http://www.recipepuppy.com/api/";
//        String url = "http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet";

        String ingredient = JOptionPane.showInputDialog("Input an ingredient that the dish must have");
        String dish = JOptionPane.showInputDialog("Input what kind of dish you want");
        String url = "http://www.recipepuppy.com/api/?i=" + ingredient + "&q=" + dish + "&p=1";
        URL theUrl = new URL(url);
        URLConnection urlc = theUrl.openConnection();

        //get result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc
                .getInputStream()));
        String l = null;
        while ((l = br.readLine()) != null) {
            networkPanel.setJsonData(l);
        }
        br.close();
    }

    private void parse() {
        try {
            FoodParserGUI libParser = new FoodParserGUI();
            libParser.parseLibrary(networkPanel.getJsonData());
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }
    }

    //EFFECTS: run readsource and main
    public void main() throws IOException, JSONException {
        readSource();
        parse();
    }

    protected static ImageIcon createScaledImageIcon(String path) {
//        java.net.URL imgURL = Tool.class.getResource(path);
        java.net.URL imgURL = loader.getResource(path);
        ImageIcon img;
        img = new ImageIcon(imgURL);
        Image newimg = img.getImage().getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            main();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
}
