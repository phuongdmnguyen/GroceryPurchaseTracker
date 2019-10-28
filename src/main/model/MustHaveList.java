package model;

import model.items.Item;
import ui.PersonalSettings;

import java.util.ArrayList;

public class MustHaveList extends PersonalLists {
    protected ArrayList<String> listOfMustHaves;
    protected PersonalSettings personalSettings;

    public MustHaveList() {
        listOfMustHaves = new ArrayList<>();
        personalSettings = new PersonalSettings();
    }

    public void addItemToMHList(String item) {
        listOfMustHaves.add(item);
    }

}
