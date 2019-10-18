package ui;

import model.Exceptions.BudgetIssuesException;
import model.Exceptions.BudgetReachedException;
import model.Exceptions.NoBudgetException;
import model.GroceriesList;
import model.Items.*;
import model.MustHaveList;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private static GroceriesList groceriesList;
    private static MustHaveList mustHaveList;
    private static Scanner myObj;

    protected static void processGroceries() {
        init();
        displayMenu();
        addUserInputToGroceries();
        checkGroceryListSufficient();
        System.out.println("The total cost of this trip: " + groceriesList.getTotalCost() + " dollars");
    }

    public static void init() {
        groceriesList = new GroceriesList();
        mustHaveList = new MustHaveList();
        myObj = new Scanner(System.in);
    }

    public static void displayMenu() {
        System.out.println("\nSelect from category:");
        System.out.println("\tm -> meat");
        System.out.println("\tg -> grocery");
        System.out.println("\tp -> produce");
        System.out.println("\th -> household item");
        System.out.println("\tq -> quit");
    }


    protected static void addUserInputToGroceries() {
        String command = null;

        while (true) {
            displayMenu();
            command = myObj.next();
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
        String iname = myObj.next();
        System.out.println("Input item's cost");
        double icost = myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = myObj.nextInt();
        Item item = new Meat(iname, icost, iquantity);
        groceriesList.addItem(item);
    }

    public static void addGrocery() {
        System.out.println("Input item's name/quit");
        String iname = myObj.next();
        System.out.println("Input item's cost");
        double icost = myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = myObj.nextInt();
        Item item = new Grocery(iname, icost, iquantity);
        groceriesList.addItem(item);
    }

    public static void addProduce() {
        System.out.println("Input item's name/quit");
        String iname = myObj.next();
        System.out.println("Input item's cost");
        double icost = myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = myObj.nextInt();
        Item item = new Produce(iname, icost, iquantity);
        groceriesList.addItem(item);
    }

    public static void addHouseholdItem() {
        System.out.println("Input item's name/quit");
        String iname = myObj.next();
        System.out.println("Input item's cost");
        double icost = myObj.nextDouble();
        System.out.println("Input item's quantity");
        int iquantity = myObj.nextInt();
        Item item = new HouseholdItem(iname, icost, iquantity);
        groceriesList.addItem(item);
    }

    public static void checkGroceryListSufficient() {
        try {
            groceriesList.isContainMustHaves(mustHaveList);
        } catch (NoBudgetException e) {
            System.out.println("Please set budget before proceeding");
        } catch (BudgetIssuesException e) {
            System.out.println("There is some budget issues");
        } finally {
            System.out.println("All good");
        }
    }

    public static void main(String[] args) {
        processGroceries();
    }

}
