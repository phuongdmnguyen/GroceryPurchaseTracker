package placeholder;

import java.util.ArrayList;
import java.util.Scanner;

public class Groceries {
    private Scanner scanner;

    public Groceries() {
        ArrayList<Item> groceries = new ArrayList<Item>();
        scanner = new Scanner(System.in);
        processGroceries();
    }

    private void processGroceries() {
        String iname = "";
        String icost = "";
        String iquantity = "";

        while (true) {
            System.out.println("Please input your item's name or quit");
            iname = scanner.nextLine();
            System.out.println("Please input your item's cost");
            icost = scanner.nextLine();
            int ic = Integer.parseInt(icost);
            System.out.println("Please input your item's quantity");
            iquantity = scanner.nextLine();
            int iq = Integer.parseInt(iquantity);
            Item item = new Item(iname, ic, iq);

            if (iname.equals("quits")) {
                break;
            }

            System.out.println("end");
        }
    }


    private int getTotal(ArrayList<Item> groceries) {
        int sum = 0;
        for (Item i : groceries) {
            sum += i.cost;
        }
        return sum;
    }

    public void main(String[] args) {
        processGroceries();
        getTotal(groceries);
    }
}
