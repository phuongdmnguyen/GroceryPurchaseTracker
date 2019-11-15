package model;

import model.items.Item;

import java.util.ArrayList;
import java.util.Observable;

public abstract class PersonalList extends Observable {
    protected ArrayList<Item> itemsList;
    public int budget;

    public PersonalList() {
        itemsList = new ArrayList<>();
        budget = 0;
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
