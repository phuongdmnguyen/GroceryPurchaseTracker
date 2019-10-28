package model;

import model.items.Item;
import ui.PersonalSettings;

import java.util.ArrayList;

public class MustHaveList extends PersonalLists {
    protected ArrayList<String> listOfMustHaves;
    protected GroceriesList groceriesList;

    public MustHaveList() {
        listOfMustHaves = new ArrayList<>();
        groceriesList = new GroceriesList();
    }

    public void addItemToMHList(String item) {
        listOfMustHaves.add(item);
    }

}
