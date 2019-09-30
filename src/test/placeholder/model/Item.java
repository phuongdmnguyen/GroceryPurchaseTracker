package placeholder.model;

import java.util.ArrayList;

public class Item {
    private String name; // name of item
    private double cost; // cost per item
    private int quantity; // amount bought

    public Item(String n, double c, int q) {
        name = n;
        cost = c;
        quantity = q;
    }

    public String getItemName() {
        return name;
    }

    public double getItemTotalCost() {
        return cost * quantity;
    }

    public int getItemQuantity() {
        return quantity;
    }

    public void setItemName(String in) {
        this.name = in;
    }

    public void setItemCost(double ic) {
        this.cost = ic;
    }

    public void setItemQuantity (int iq) {
        this.quantity = iq;
    }
}