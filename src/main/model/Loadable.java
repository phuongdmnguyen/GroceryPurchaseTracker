package model;

import model.items.Item;

import java.io.IOException;

public interface Loadable {
    Item load() throws IOException;
}
