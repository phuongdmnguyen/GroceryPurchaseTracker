import java.util.ArrayList;


public class Item {
    String name; // name of item
    double cost; // cost per item
    int quantity; // amount bought
    int calorie; // "sale" or normal
    ArrayList<Item> sale;

    public Item(String n, int c, int q, int k) {
        name = n;
        cost = c;
        quantity = q;
        calorie = k;
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

    private String isHealth(Item item) {
        if (item.calorie < 300)
            return "Healthy";
        return "Unhealthy";
    }
}

