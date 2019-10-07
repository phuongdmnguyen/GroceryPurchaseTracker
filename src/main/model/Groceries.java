package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Groceries implements Savable, Loadable {
    protected ArrayList<Item> groceries;
    public static int BUDGET = 60;

    public Groceries() {
        groceries = new ArrayList<>();
    }

    //REQUIRES: groceries cannot be empty
    //EFFECTS: get the total cost of a trip of groceries
    public int getTotalCost() {
        int sum = 0;
        for (Item i : groceries) {
            sum += i.getItemTotalCost();
        }
        return sum;
    }

    //REQUIRES: getTotalCost and budget must be > 0
    //EFFECTS: return true if total cost of one trip of groceries is <= budget
    public boolean isWithinBudget() {
        return getTotalCost() <= BUDGET;
    }

    //REQUIRES: groceries must not be empty
    //EFFECTS: count number of items in one trip of groceries
    public int countItem() {
        return groceries.size();
    }

    //EFFECTS: if groceries doesn't contain items in must haves, add to shoppingList
    // return shopping list
    public Groceries isContainMustHaves(PersonalLists mh) {
        Groceries shoppinglist = new Groceries();
        for (Item i : mh.getMustHaves()) {
            if (!groceries.contains(i)) {
                shoppinglist.addItem(i);
            }
        }
        return shoppinglist;
    }


    public void addItem(Item item) {
        groceries.add(item);
    }

    public int size() {
        return groceries.size();
    }

    public void itemExpired() {
        for (Item i : groceries) {
            i.itemExpired();
        }
    }

    public void load() throws IOException {
        FileInputStream saveFile = new FileInputStream("saveFile.sav");
        ObjectInputStream restore = new ObjectInputStream(saveFile);
        restore.readUTF();
        restore.close();
        System.out.println("Yay File loaded");
    }

    @Override
    public void save() throws IOException {
        PrintWriter writer = new PrintWriter("grocOutput.txt", "UTF-8");
        for (Item i : groceries) {
            writer.print(i.getItemName() + " ");
            writer.print("quantity: " + i.getItemQuantity() + "; ");
            writer.print("total cost:" + i.getItemTotalCost() + "; ");
            writer.println(" ");
        }
        writer.close();
    }
}
