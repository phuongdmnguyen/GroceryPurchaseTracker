package model.items;

import java.util.Objects;

public abstract class Item {
    protected String name; // name of item
    protected String category;//category if Item
    protected double cost; // cost per item
    protected int quantity; // amount bought


    public Item(String n, double c, int q) {
        name = n;
        cost = c;
        quantity = q;

    }

    public String getItemName() {
        return name;
    }

    public Double getItemCost() {
        return cost;
    }

    public double getItemTotalCost() {
        return cost * quantity;
    }

    public int getItemQuantity() {
        return quantity;
    }

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
                && quantity == item.quantity
                && name.equals(item.name)
                && category.equals(item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, cost, quantity);
    }
}
