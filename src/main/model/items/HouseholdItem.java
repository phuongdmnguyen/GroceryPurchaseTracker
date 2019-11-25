package model.items;

public class HouseholdItem extends Item {

    public HouseholdItem(String n) {
        super(n, "HouseholdItem");
    }

    @Override
    public void putItemIntoCategory() {
        categorizedItems.put("HouseholdItem", this);
    }
}
