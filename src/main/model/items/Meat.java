package model.items;

public class Meat extends Item {
    public Meat(String n) {
        super(n, "Meat");
    }

    //EFFECT: put this item into a its category
    @Override
    public void putItemIntoCategory() {
        categorizedItems.put("Meat", this);
    }
}

