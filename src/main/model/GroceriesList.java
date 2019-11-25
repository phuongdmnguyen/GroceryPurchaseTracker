package model;

import model.exceptions.BudgetReachedException;
import model.exceptions.NoBudgetException;
import model.items.Item;
import model.items.Meat;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class GroceriesList extends PersonalList implements Iterable<Item> {
    protected ArrayList<String> shoppingList;
    //general items categorized by its category

    public GroceriesList(ShoppingListMonitor shoppingListMonitor) {
        shoppingList = new ArrayList<>();
        addObserver(shoppingListMonitor);
    }


    //REQUIRES: groceries cannot be empty
    //EFFECTS: get the total cost of a trip of groceries
    public int getTotalCost() {
        int sum = 0;
        for (Item i : itemsList) {
            sum += i.getItemTotalCost();
        }
        return sum;
    }

    public Item getSpecificItemInList(int i) {
        return itemsList.get(i);
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
    public ArrayList<String> isContainMustHaves(MustHaveList mh) throws BudgetReachedException, NoBudgetException {
        if (budget < getTotalCost()) {
            throw new BudgetReachedException();
        }

        if (budget == 0) {
            throw new NoBudgetException();
        }
        ArrayList<String> list = getNamesofItemsInGroceryList(this);
        for (String i : mh.listOfMustHaves) {
            if (!list.contains(i)) {
                shoppingList.add(i);
                setChanged();
                notifyObservers();
            }
        }
        System.out.println(shoppingList);
        return shoppingList;
    }

    public ArrayList<String> getShoppingList() {
        return shoppingList;
    }

    public ArrayList<String> getNamesofItemsInGroceryList(GroceriesList groceriesList) {
        ArrayList<String> listOfItemNames = new ArrayList<>();
        for (Item i:groceriesList.itemsList) {
            String itemName = i.getItemName();
            listOfItemNames.add(itemName);
        }
        return listOfItemNames;
    }


    public ArrayList<Item> load() throws IOException {
        Scanner reader = new Scanner(new File("grocOutput.txt"));
        while (reader.hasNextLine()) {
            String itemName = reader.nextLine();
            Item item = new Meat(itemName) {
            };
            itemsList.add(item);
            return itemsList;
        }
        return itemsList;
    }

    public void save() throws IOException {
        PrintWriter writer = new PrintWriter("grocOutput.txt", "UTF-8");
        for (Item i : itemsList) {
            writer.println(i.getItemName());
            writer.println(" ");
        }
        writer.close();
    }

    @Override
    public Iterator<Item> iterator() {
        return itemsList.iterator();
    }
}
