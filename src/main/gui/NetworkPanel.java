package gui;

import gui.networktools.Tool;
import org.json.JSONException;
import sun.nio.ch.Net;
import network.FoodRecipeWeb;
import network.FoodParser;
import ui.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class NetworkPanel extends Panel {
    private FoodRecipeWeb foodRecipeWeb;
    protected String jsonData;

    public NetworkPanel() throws IOException, JSONException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = "Network";
        JPanel filler = new JPanel();
        filler.setBackground(Color.WHITE);
        add(filler,TOP_ALIGNMENT);
        initializeTools();
    }

    public void setJsonData(String data) {
        jsonData = data;
    }

    public String getJsonData() {
        return jsonData;
    }

    //EFFECTS: create recipeTool and place it at the bottom of screen
    public void initializeTools() throws IOException {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(0,1));
        toolArea.setPreferredSize(new Dimension(100,100));
        add(toolArea, BOTTOM_ALIGNMENT);

        Tool recipeTool = new Tool(this,toolArea);
    }


    @Override
    protected String getTitle() {
        return title;
    }
}
