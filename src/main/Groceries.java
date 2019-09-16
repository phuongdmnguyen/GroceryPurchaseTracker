import java.util.ArrayList;

public class Groceries {
    private static ArrayList<Item> groceries;

    public Groceries() {
        groceries = new ArrayList<>();
        addItem();

    }

    private void addItem(Item item) {
        Item i = new Item();
        groceries.add(item);
    }

    public static ArrayList<Item> getGroceries(ArrayList<Item> groceries) {
        for (Item i: groceries)
            System.out.println(i.name);
        return groceries;
    }


    public static int getTotal(ArrayList<Item> groceries) {
        int sum = 0;
        for (Item i: groceries) {
            sum += i.cost;
        }
        return sum;
    }

    public static void main(String[]args) {
        new Groceries();
    }
}

