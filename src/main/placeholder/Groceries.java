package placeholder;

import java.util.ArrayList;
import java.util.Scanner;

public class Groceries {
    private ArrayList<Item> groceries;
    private Scanner scanner;

    public Groceries() {
        groceries = new ArrayList<Item>();
        scanner = new Scanner(System.in);
        processGroceries();
    }

    private void processGroceries() {
        String iname = "";

        while (true) {
            System.out.println("Please input your item's name or quit");
            iname = scanner.nextLine();

            Item item = new Item(iname);

            if (iname.equals("quit")) {
                break;
            }

            System.out.println(iname);
        }

        System.out.println("end here!");
    }


    private int getTotal(ArrayList<Item> groceries) {
        int sum = 0;
        for (Item i : groceries) {
            sum += i.cost;
        }
        return sum;
    }

    public static void main(String[] args) {
        processGroceries();
        getTotal();
    }
}
