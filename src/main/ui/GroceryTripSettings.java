package ui;

import model.GroceriesList;
import model.exceptions.BudgetIssuesException;
import model.exceptions.NoBudgetException;
import model.items.*;
import org.json.JSONException;

import java.io.IOException;

import static ui.UserInterface.userInputChoices;

public class GroceryTripSettings {
    static GroceriesList groceriesList;

    public static void displayGroceryTripMenu() {
        System.out.println("\nSelect from category:");
        System.out.println("\tm -> meat");
        System.out.println("\tg -> grocery");
        System.out.println("\tp -> produce");
        System.out.println("\th -> household item");
        System.out.println("\te -> exit");
    }

    protected static void addUserInputToGroceries() throws IOException, JSONException {
        boolean keepGoing = true;

        while (keepGoing) {
            displayGroceryTripMenu();
            String command = UserInterface.myObj.next();
            command = command.toLowerCase();

            if (command.equals("m")) {
                addMeat();
            } else if (command.equals("g")) {
                addGrocery();
            } else if (command.equals("p")) {
                addProduce();
            } else if (command.equals("h")) {
                addHouseholdItem();
            } else if (command.equals("e")) {
                keepGoing = false;
            }
        }
        userInputChoices();
    }

    public static void addMeat() {
        System.out.println("Input item's name/quit");
        String iname = UserInterface.myObj.next();
        System.out.println("Input item's cost");
        double icost = UserInterface.myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = UserInterface.myObj.nextInt();
        Item item = new Meat(iname);
        itemSetUp(icost, iquantity, item);
    }

    public static void itemSetUp(double icost, int iquantity, Item item) {
        item.setCost(icost);
        item.setQuantity(iquantity);
        groceriesList.addItem(item);
    }

    public static void addGrocery() {
        System.out.println("Input item's name");
        String iname = UserInterface.myObj.next();
        System.out.println("Input item's cost");
        double icost = UserInterface.myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = UserInterface.myObj.nextInt();
        Item item = new Grocery(iname);
        itemSetUp(icost, iquantity, item);
    }

    public static void addProduce() {
        System.out.println("Input item's name");
        String iname = UserInterface.myObj.next();
        System.out.println("Input item's cost");
        double icost = UserInterface.myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = UserInterface.myObj.nextInt();
        Item item = new Produce(iname);
        item.setQuantity(iquantity);
        item.setCost(icost);
        groceriesList.addItem(item);
    }

    public static void addHouseholdItem() {
        System.out.println("Input item's name/quit");
        String iname = UserInterface.myObj.next();
        System.out.println("Input item's cost");
        double icost = UserInterface.myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = UserInterface.myObj.nextInt();
        Item item = new HouseholdItem(iname);
        itemSetUp(icost, iquantity, item);
    }

}
