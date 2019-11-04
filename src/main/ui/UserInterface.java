package ui;

import model.GroceriesList;
import model.MustHaveList;

import java.util.Scanner;

public class UserInterface {
    protected static MustHaveList mustHaveList;
    private static PersonalSettings personalSettings;
    protected static Scanner myObj;

    protected static void processGroceries() {
        init();
        userInputChoices();
        GroceryTripSettings.displayGroceryTripMenu();
        GroceryTripSettings.addUserInputToGroceries();
        GroceryTripSettings.checkGroceryListSufficient();
    }

    public static void init() {
        GroceryTripSettings.groceriesList = new GroceriesList();
        mustHaveList = new MustHaveList();
        myObj = new Scanner(System.in);
        personalSettings = new PersonalSettings();
    }

    public static void displayChoices() {
        System.out.println("\nChoose things to do:");
        System.out.println("\tbudget -> set personal budget");
        System.out.println("\tmusthave -> add items to must have list");
        System.out.println("\tgrocery -> add a grocery trip");
//        System.out.println("\tcheckgroc -> check items in one category");
        System.out.println("\tquit -> quit application");
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
            } else if (command.equals("grocery")) {
                GroceryTripSettings.addUserInputToGroceries();
            } else if (command.equals("quit")) {
                System.out.println("The total cost of this trip: "
                        + GroceryTripSettings.groceriesList.getTotalCost() + " dollars");
                break;
            }
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


    public static void main(String[] args) {
        processGroceries();
    }

}
