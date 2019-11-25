package model;

import java.util.ArrayList;

public class MustHaveList {
    protected ArrayList<String> listOfMustHaves;

    public MustHaveList() {
        listOfMustHaves = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: add item to musthave list
    public void addItemToMHList(String item) {
        listOfMustHaves.add(item);
    }

}
