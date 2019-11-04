package model;

import model.items.Item;

import java.util.ArrayList;

public abstract class PersonalList {
    protected ArrayList<Item> itemsList;
    protected int budget;

    public PersonalList() {
        itemsList = new ArrayList<>();
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void addItem(Item i) {
        if (!itemsList.contains(i)) {
            itemsList.add(i);
            i.assignToList(this);
        }
    }

//    public void removeItem(Item i) {
//        itemsList.remove(i);
//    }
//
//    public ArrayList<Item> getList() {
//        return itemsList;
//    }

    public int size() {
        return itemsList.size();
    }

}
