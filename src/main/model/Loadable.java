package model;

import model.Items.Item;

import java.io.IOException;

public interface Loadable {
    Item load() throws IOException;
}
