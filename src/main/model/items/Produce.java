package model.items;

public class Produce extends Item {

    public Produce(String n) {
        super(n, "Produce");
    }

    //EFFECT: put this item into a its category
    @Override
    public void putItemIntoCategory() {
        categorizedItems.put("Produce", this);
    }
}
