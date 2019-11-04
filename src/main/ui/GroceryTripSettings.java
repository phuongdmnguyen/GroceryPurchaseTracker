package ui;

import model.GroceriesList;
import model.exceptions.BudgetIssuesException;
import model.exceptions.NoBudgetException;
import model.items.*;

public class GroceryTripSettings {
    static GroceriesList groceriesList;

    public static void displayGroceryTripMenu() {
        System.out.println("\nSelect from category:");
        System.out.println("\tm -> meat");
        System.out.println("\tg -> grocery");
        System.out.println("\tp -> produce");
        System.out.println("\th -> household item");
        System.out.println("\tq -> quit");
    }

    protected static void addUserInputToGroceries() {
        String command;

        while (true) {
            displayGroceryTripMenu();
            command = UserInterface.myObj.next();
            command = command.toLowerCase();

            if (command.equals("m")) {
                addMeat();
            } else if (command.equals("g")) {
                addGrocery();
            } else if (command.equals("p")) {
                addProduce();
            } else if (command.equals("h")) {
                addHouseholdItem();
            } else if (command.equals("q")) {
                break;
            }
        }
        System.out.println("\nGoodbye!");
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

    public static void checkGroceryListSufficient() {
        try {
            groceriesList.isContainMustHaves(UserInterface.mustHaveList);
        } catch (NoBudgetException e) {
            System.out.println("Please set budget before proceeding");
        } catch (BudgetIssuesException e) {
            System.out.println("There is some budget issues");
        } finally {
            System.out.println("All good");
        }
    }
}
