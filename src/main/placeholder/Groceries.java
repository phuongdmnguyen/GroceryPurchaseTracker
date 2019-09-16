package placeholder;

import java.util.ArrayList;
import java.util.Scanner;

public class Groceries {
    private Scanner scanner;

    public Groceries() {
        ArrayList<Item> groceries = new ArrayList<Item>();
        scanner = new Scanner(System.in);
        processGroceries();
        getTotal(groceries);
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


    private static int getTotal(ArrayList<Item> groceries) {
        int sum = 0;
        for (Item i : groceries) {
            sum += i.cost;
        }
        return sum;
    }
d
    public static void main(String[] args) {
        new Groceries();;
    }
}
