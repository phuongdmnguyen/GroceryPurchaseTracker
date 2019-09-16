package placeholder;

import java.util.ArrayList;


public class Item {
    String name; // name of item
    double cost; // cost per item
    int quantity; // amount bought
    ArrayList<Item> sale;

    public Item(String n, double c, int q) {
        name = n;
        cost = c;
        quantity = q;
        sale = new ArrayList<Item>();
    }

    public void setSaleCost(ArrayList<Item> sale) {
        for (Item i : sale) {
            i.setCost(i);
        }
    }

    private void setCost(Item item) {
        item.cost = item.cost * .9;
    }
}


