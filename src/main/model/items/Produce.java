package model.items;

public class Produce extends Item {

    public Produce(String n) {
        super(n, "Produce");
    }

    @Override
    public void putItemIntoCategory(Item item) {
        categorizedItems.put("Produce", item);
    }
}
