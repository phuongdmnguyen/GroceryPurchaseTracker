package model;

import java.util.ArrayList;

public abstract class Item {
    protected String name; // name of item
    protected double cost; // cost per item
    protected int quantity; // amount bought
    protected int daysTillExpiry; // days till expiry
    protected boolean expiryStatus; // true = has expired, false otherwise

    public Item(String n, double c, int q, int e, boolean s) {
        name = n;
        cost = c;
        quantity = q;
        daysTillExpiry = e;
        expiryStatus = s;

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

    //REQUIRES: daysTillExpiry = 0
    //MODIFIES: this
    //EFFECTS: sets expiryStatus to true once days till expiry = 0
    public abstract void itemExpired();
}