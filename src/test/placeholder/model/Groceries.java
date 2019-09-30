package placeholder.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Groceries implements GrocEntry{
    private ArrayList<Item> groceries;
    public int BUDGET = 60;



    public Groceries() {
        groceries = new ArrayList<>();
        getTotalCost();
        isWithinBudget();
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
       if (getTotalCost() <= BUDGET) {
           return true;
       }
        return false;
    }

    //REQUIRES: groceries must not be empty
    //EFFECTS: count number of items in one trip of groceries
    public int countItem(){
        return groceries.size();
    }

    //EFFECTS: if groceries doesn't contain items in must haves, add to shoppingList
    // return shopping list
    public Groceries isContainMustHaves(PersonalLists mh){
        Groceries shoppinglist = new Groceries();
        for (Item i: mh.getMustHaves()){
            if (!groceries.contains(i)){
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

    public void load() {

    }

    public void save() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));;
        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
        lines.add("Groceries list:");
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("Name: "+partsOfLine.get(0)+" ");
            System.out.println("Role: "+partsOfLine.get(1));
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.
    }


    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    @Override
    public void date() {
        System.out.println("Shopping was done on");
    }
}
