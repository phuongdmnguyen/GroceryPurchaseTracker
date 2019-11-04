package model.items;

public class Meat extends Item {
    public Meat(String n) {
        super(n, "Meat");
    }

    @Override
    public void putItemIntoCategory(Item item) {
        categorizedItems.put("Meat",item);
    }
}

