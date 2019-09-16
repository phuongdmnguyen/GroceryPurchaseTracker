import java.util.ArrayList;
import java.util.Scanner;

public class Groceries {
    private  ArrayList<Item> groceries;
    private Scanner scanner;

    public Groceries() {
        groceries = new ArrayList<>();
        scanner = new Scanner(System.in);
        processGroceries();
    }

    private void processGroceries() {
        String iname = "";
        String icost = "";
        String iquantity = "";
        String icalorie = "";

        while (true) {
            System.out.println("Please input your item's name");
            iname = scanner.nextLine();
            System.out.println("Please input your item's cost");
            icost = scanner.nextLine();
            int ic = Integer.parseInt(icost);
            System.out.println("Please input your item's quantity");
            iquantity = scanner.nextLine();
            int iq = Integer.parseInt(iquantity);
            System.out.println("Please input your item's calorie");
            icalorie = scanner.nextLine();
            int ik = Integer.parseInt(icalorie);
            Item item = new Item(iname,ic,iq,ik);

            groceries.add(item);
        }
    }

    public static ArrayList<Item> getGroceries(ArrayList<Item> groceries) {
        for (Item i: groceries)
            System.out.println(i.name);
        return groceries;
    }


    public static int getTotal(ArrayList<Item> groceries) {
        int sum = 0;
        for (Item i: groceries) {
            sum += i.cost;
        }
        return sum;
    }

    public static void main(String[]args) {
        new Groceries();
    }
}

