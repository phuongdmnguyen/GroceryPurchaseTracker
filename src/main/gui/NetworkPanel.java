package gui;

import gui.networktools.Tool;
import org.json.JSONException;
import sun.nio.ch.Net;
import network.FoodRecipeWeb;
import network.FoodParser;
import ui.UserInterface;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class NetworkPanel extends Panel {
    private FoodRecipeWeb foodRecipeWeb;
    protected String jsonData;

    public NetworkPanel() throws IOException, JSONException {
        title = "Network";
        Tool recipeTool = new Tool(this,this);
    }

    public void setJsonData(String data) {
        jsonData = data;
    }

    public String getJsonData() {
        return jsonData;
    }


    @Override
    protected String getTitle() {
        return title;
    }
}
