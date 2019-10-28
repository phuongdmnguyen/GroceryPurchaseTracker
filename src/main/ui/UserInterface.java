package ui;

import model.exceptions.BudgetIssuesException;
import model.exceptions.NoBudgetException;
import model.GroceriesList;
import model.items.*;
import model.MustHaveList;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class UserInterface {
    private static GroceriesList groceriesList;
    private static MustHaveList mustHaveList;
    private static PersonalSettings personalSettings;
    private static Scanner myObj;

    protected static void processGroceries() {
        init();
        displayChoices();
        userInputChoices();
        displayGroceryTripMenu();
        addUserInputToGroceries();
        checkGroceryListSufficient();
        System.out.println("The total cost of this trip: " + groceriesList.getTotalCost() + " dollars");
    }

    public static void init() {
        groceriesList = new GroceriesList();
        mustHaveList = new MustHaveList();
        myObj = new Scanner(System.in);
        personalSettings = new PersonalSettings();
    }

    public static void displayGroceryTripMenu() {
        System.out.println("\nSelect from category:");
        System.out.println("\tm -> meat");
        System.out.println("\tg -> grocery");
        System.out.println("\tp -> produce");
        System.out.println("\th -> household item");
        System.out.println("\tq -> quit");
    }

    public static void displayChoices() {
        System.out.println("\nChoose things to do:");
        System.out.println("\tbudget -> set personal budget");
        System.out.println("\tmusthave -> add items to must have list");
        System.out.println("\tgrocery -> add a grocery trip");
        System.out.println("\tcheckgroc -> check items in one category");
    }

    public static void userInputChoices() {
        String command;

        while (true) {
            displayChoices();
            command = myObj.next();
            command = command.toLowerCase();

            if (command.equals("budget")) {
                setPersonalBudget();
            } else if (command.equals("musthave")) {
                addToMustHave();
            } else if (command.equals("checkgroc")) {
                checkGroceryList("Item");
            }
        }
    }


    protected static void addUserInputToGroceries() {
        String command;

        while (true) {
            displayGroceryTripMenu();
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

    public static void setPersonalBudget() {
        System.out.println("Enter your budget:");
        double myBudget = myObj.nextDouble();
        personalSettings.setBudget(myBudget);
    }

    public static void addToMustHave() {
        System.out.println("Add items to your must have list!");
        String mustHaveItem = myObj.next();
        personalSettings.addMustHaves(mustHaveItem);
    }

    public static void checkGroceryList(String category) {
        groceriesList.getItemsInOneCategory(category);
    }

    public static void main(String[] args) {
        processGroceries();
    }

}
