package model;

import model.items.Item;

import java.util.ArrayList;

public abstract class PersonalLists {
    protected ArrayList<Item> itemsList;
    protected int budget;

    public PersonalLists() {
        itemsList = new ArrayList<>();
    }

    public void addItem(Item i) {
        itemsList.add(i);
    }

    public void removeItem(Item i) {
        itemsList.remove(i);
    }

    public ArrayList<Item> getList() {
        return itemsList;
    }

    public int size() {
        return itemsList.size();
    }

}
