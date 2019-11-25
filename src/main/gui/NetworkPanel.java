package gui;

import sun.nio.ch.Net;

public class NetworkPanel extends Panel {

    public NetworkPanel() {
        title = "Network";
    }

    @Override
    protected String getTitle() {
        return title;
    }
}
