package placeholder.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Groceries {
    private Scanner scanner;
    private ArrayList<Item> groceries;
    private int budget;


    public Groceries() {
        groceries = new ArrayList<>();
        scanner = new Scanner(System.in);
        budget = 60;
        //processGroceries();
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
       if (getTotalCost() <= budget) {
           return true;
       }
        return false;
    }

    //REQUIRES: groceries must not be empty
    //EFFECTS: count number of items in one trip of groceries
    public int countItem(){
        return groceries.size();
    }

    public Groceries isContainMustHaves(PersonalLists mh){
        Groceries shoppinglist = new Groceries();
        for (Item i: mh.getMustHaves()){
            if (groceries.contains(i)){
                return shoppinglist;
            }
            shoppinglist.addItem(i);
        }
        return shoppinglist;
    }

    private void processGroceries() {

        String iname = "";
        String icost = "";
        String iquantity = "";

        while (true) {
            System.out.println("Input item's name/quit");
            iname = scanner.nextLine();
            System.out.println("Input item's cost");
            icost = scanner.nextLine();
            double ic = Double.parseDouble(icost);
            System.out.println("Input item's quantity");
            iquantity = scanner.nextLine();
            int iq = Integer.parseInt(iquantity);
            Item item = new Item(iname, ic, iq);

            if (iname.equals("quits")) {
                break;
            }

            System.out.println("end");
        }
    }

    public void addItem(Item item) {
        groceries.add(item);
    }

    /*public static void main(String[] args) {
        new Groceries();;
    }
     */

    public int size() {
        return groceries.size();
    }
}
