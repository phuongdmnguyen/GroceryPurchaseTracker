package placeholder.ui;

import placeholder.model.Groceries;
import placeholder.model.Item;

import java.util.Scanner;

public class Main {
    private static void processGroceries() {
        Groceries groceries = new Groceries();
        Scanner myObj = new Scanner(System.in);

        while (true) {
            System.out.println("Input item's name/quit");
            String iname = myObj.next();
            if (iname.equals("quit")) {
                break;
            }
            System.out.println("Input item's cost");
            double icost = myObj.nextDouble();
            System.out.println("Input item's quantity");
            int iquantity = myObj.nextInt();
            Item item = new Item(iname, icost, iquantity);
            groceries.addItem(item);
        }
        System.out.println("The total cost of this trip: " + groceries.getTotalCost() + " dollars");
    }

    public static void main(String[] args) {
        processGroceries();
    }
}
