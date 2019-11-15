package model;

import java.util.ArrayList;

public class MustHaveList {
    protected ArrayList<String> listOfMustHaves;

    public MustHaveList() {
        listOfMustHaves = new ArrayList<>();
    }

    public void addItemToMHList(String item) {
        listOfMustHaves.add(item);
    }

}
