package model.items;

import model.PersonalList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class Item {
    protected String name; // name of item
    protected String category;//category if Item
    protected double cost; // cost per item
    protected int quantity; // amount bought
    private ArrayList<PersonalList> personalLists; //item is part of a personalList

    protected static HashMap<String,Item> categorizedItems;

    public Item(String n, String category) {
        name = n;
        this.category = category;
        cost = 0.0;
        quantity = 0;
        personalLists = new ArrayList<>();
        categorizedItems = new HashMap<>();
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return name;
    }

    public Double getItemCost() {
        return cost;
    }

    //REQUIRES: cost and quantity > 0
    //EFFECTS: return the total cost of an item by multiplying cost by quantity
    public double getItemTotalCost() {
        return cost * quantity;
    }

    public int getItemQuantity() {
        return quantity;
    }

    public ArrayList<PersonalList> getPersonalLists() {
        return personalLists;
    }

    //EFFECTS: assign this item to a personal list if that list doesn't already contain the item;
    //MODIFIES: this, personalLists
    // if list has item, then do nothing
    public void assignToList(PersonalList personalList) {
        if (!this.personalLists.contains(personalList)) {
            this.personalLists.add(personalList);
            personalList.addItem(this);
        }
    }

    public abstract void putItemIntoCategory();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Double.compare(item.cost, cost) == 0
                && name.equals(item.name)
                && category.equals(item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, cost);
    }
}
