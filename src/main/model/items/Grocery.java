package model.items;

import java.util.ArrayList;

public class Grocery extends Item {


    public Grocery(String n) {
        super(n, "Grocery");
    }

    //EFFECT: put this item into a its category
    @Override
    public void putItemIntoCategory() {
        categorizedItems.put("Grocery", this);
    }
}
