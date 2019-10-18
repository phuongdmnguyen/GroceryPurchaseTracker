package model.items;

public abstract class Item {
    protected String name; // name of item
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
}
