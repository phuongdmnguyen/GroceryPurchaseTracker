package model;

import model.exceptions.BudgetReachedException;
import model.exceptions.NoBudgetException;
import model.items.Item;

import java.io.*;
import java.util.Scanner;


public class GroceriesList extends PersonalLists {

    public GroceriesList() { }


    //REQUIRES: groceries cannot be empty
    //EFFECTS: get the total cost of a trip of groceries
    public int getTotalCost() {
        int sum = 0;
        for (Item i : itemsList) {
            sum += i.getItemTotalCost();
        }
        return sum;
    }

//    REQUIRES: getTotalCost and budget must be > 0
//    EFFECTS: return true if total cost of one trip of groceries is <= budget
    public boolean isWithinBudget() {
        return getTotalCost() <= budget;
    }

    //REQUIRES: groceries must not be empty
    //EFFECTS: count number of items in one trip of groceries
    public int countItem() {
        return itemsList.size();
    }

    //EFFECTS: if groceries doesn't contain items in must haves, add to shoppingList
    // return shopping list
    public GroceriesList isContainMustHaves(MustHaveList mh) throws BudgetReachedException, NoBudgetException {
        if (budget < getTotalCost()) {
            throw new BudgetReachedException();
        }

        if (budget == 0) {
            throw new NoBudgetException();
        }
        GroceriesList shoppinglist = new GroceriesList();
        for (Item i : mh.itemsList) {
            if (!itemsList.contains(i)) {
                shoppinglist.addItem(i);
            }
        }
        return shoppinglist;
    }


    public Item load() throws IOException {
        GroceriesList groceriesList = new GroceriesList();
        Scanner reader = new Scanner(new File("grocOutput.txt"));
        while (reader.hasNextLine()) {
            String itemName = reader.nextLine();
            double itemCost = reader.nextDouble();
            int itemQuantity = reader.nextInt();

            Item item = new Item(itemName, itemCost, itemQuantity) {
            };
            groceriesList.addItem(item);
            return item;
        }
        return null;
    }

    public void save() throws IOException {
        PrintWriter writer = new PrintWriter("grocOutput.txt", "UTF-8");
        for (Item i : itemsList) {
            writer.println(i.getItemName());
            writer.println(i.getItemCost());
            writer.println(i.getItemQuantity());
            writer.println(" ");
        }
        writer.close();
    }
}
