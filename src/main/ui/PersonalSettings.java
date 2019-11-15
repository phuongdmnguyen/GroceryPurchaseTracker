package ui;

import model.GroceriesList;
import model.MustHaveList;
import model.PersonalList;
import model.exceptions.BudgetIssuesException;
import model.exceptions.NoBudgetException;
import model.items.Item;
import org.json.JSONException;

import java.io.IOException;

import static ui.UserInterface.userInputChoices;

public class PersonalSettings extends PersonalList {
    protected static MustHaveList listMustHaves;

    public PersonalSettings() {
        this.budget = 0;
        this.listMustHaves = new MustHaveList();
    }

    protected static void addUserInputToPersonalSettings() throws IOException, JSONException {
        boolean keepGoing = true;

        while (keepGoing) {
            displayPersonalSettingsMenu();
            String command = UserInterface.myObj.next();
            command = command.toLowerCase();

            if (command.equals("budget")) {
                setPersonalBudget();
            } else if (command.equals("musthave")) {
                addToMustHave();
            } else if (command.equals("tripsufficient?")) {
                checkGroceryListSufficient();
            } else if (command.equals("exit")) {
                keepGoing = false;
            }
        }
        userInputChoices();
    }

    public static void displayPersonalSettingsMenu() {
        System.out.println("\nSelect what to do:");
        System.out.println("\tbudget -> set your personal budget");
        System.out.println("\tmusthave -> add items to your must have list");
        System.out.println("\ttripsufficient? -> check if grocery trip contains all must haves");
        System.out.println("\texit -> exit back to main menu");
    }

    public static void setPersonalBudget() {
        System.out.println("Enter your budget:");
        int myBudget = UserInterface.myObj.nextInt();
        GroceryTripSettings.groceriesList.setBudget(myBudget);
    }

    public static void addToMustHave() {
        System.out.println("Add items to your must have list!");
        String mustHaveItem = UserInterface.myObj.next();
        UserInterface.personalSettings.listMustHaves.addItemToMHList(mustHaveItem);
    }


    public static void checkGroceryListSufficient() {
        try {
            GroceryTripSettings.groceriesList.isContainMustHaves(listMustHaves);
        } catch (NoBudgetException e) {
            System.out.println("Please set budget before proceeding");
        } catch (BudgetIssuesException e) {
            System.out.println("There is some budget issues");
        } finally {
            System.out.println("All good");
        }
    }

}
