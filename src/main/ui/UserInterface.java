package ui;

import model.GroceriesList;
import model.MustHaveList;
import model.ShoppingListMonitor;
import network.FoodRecipeWeb;
import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    protected static PersonalSettings personalSettings;
    public static Scanner myObj;

    protected static void processGroceries() throws IOException, JSONException {
        init();
        userInputChoices();
    }

    public static void init() {
        ShoppingListMonitor shoppingListMonitor = new ShoppingListMonitor();
        GroceryTripSettings.groceriesList = new GroceriesList(shoppingListMonitor);
        myObj = new Scanner(System.in);
        personalSettings = new PersonalSettings();
    }

    public static void displayChoices() {
        System.out.println("\nChoose things to do:");
        System.out.println("\tpersonalsettings -> set personal budget");
        System.out.println("\tgrocery -> add a grocery trip");
        System.out.println("\tnetwork -> find recipes from database");
        System.out.println("\tload -> load previous grocery trip");
//        System.out.println("\tcheckgroc -> check items in one category");
        System.out.println("\tquit -> quit application");
    }

    public static void userInputChoices() throws IOException, JSONException {
        boolean keepGoing = true;

        while (keepGoing) {
            displayChoices();
            String command = myObj.next();
            command = command.toLowerCase();

            if (command.equals("personalsettings")) {
                PersonalSettings.addUserInputToPersonalSettings();
            } else if (command.equals("grocery")) {
                GroceryTripSettings.addUserInputToGroceries();
            } else if (command.equals("network")) {
                FoodRecipeWeb.main();
            } else if (command.equals("load")) {
                GroceryTripSettings.groceriesList.load();
            } else if (command.equals("quit")) {
                keepGoing = false;
            }
        }
        endTrip();
    }

    public static void endTrip() throws IOException {
        System.out.println("The total cost of this trip: "
                + GroceryTripSettings.groceriesList.getTotalCost() + " dollars");
        GroceryTripSettings.groceriesList.save();
    }


    public static void main(String[] args) throws IOException, JSONException {
        processGroceries();
    }

}
