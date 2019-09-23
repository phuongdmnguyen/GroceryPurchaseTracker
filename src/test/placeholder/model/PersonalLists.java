package placeholder.model;

import java.util.ArrayList;

public class PersonalLists {
    private ArrayList<Item> mh;

    public PersonalLists() {
        mh = new ArrayList<Item>();
    }

    public void insertMustHave(Item i) {
        mh.add(i);
    }

    public void removeMustHave(Item i) {
        mh.remove(i);
    }

    public ArrayList<Item> getMustHaves(){
        return this.mh;
    }

    public void addItem(Item item) {
        mh.add(item);
    }
}
