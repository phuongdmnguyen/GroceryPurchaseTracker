package model.items;

public class HouseholdItem extends Item {

    public HouseholdItem(String n) {
        super(n, "HouseholdItem");
    }

    //EFFECT: put this item into a its category
    @Override
    public void putItemIntoCategory() {
        categorizedItems.put("HouseholdItem", this);
    }
}
