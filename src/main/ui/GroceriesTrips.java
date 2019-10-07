package ui;

import model.Groceries;
import model.Item;
import model.Meat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GroceriesTrips {

    protected static void processGroceries() throws IOException {
        Groceries groceries = new Groceries();
        addUserInputToGroceries(groceries);
        groceries.itemExpired();
        System.out.println("The total cost of this trip: " + groceries.getTotalCost() + " dollars");
    }

    protected static void addUserInputToGroceries(Groceries groceries) throws IOException {
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
            System.out.println("Input item's days till expiry");
            int iexp = myObj.nextInt();
            Item item = new Meat(iname, icost, iquantity, iexp, false);
            groceries.addItem(item);
            groceries.save();
        }
       ;
    }

    public static void main(String[] args) throws IOException {
        processGroceries();
    }

}
