package placeholder.model;

import java.util.ArrayList;

public class Meat extends Item implements Category {
    String name;
    Double cost;
    Integer quantity;
    ArrayList<Meat> listOfMeat;

    public Meat(String n, double c, int q) {
        super(n, c, q);
    }

    @Override
    public void totalCost() {
    }
}
