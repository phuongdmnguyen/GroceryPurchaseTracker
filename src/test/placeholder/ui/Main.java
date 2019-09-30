package placeholder.ui;

import placeholder.model.Groceries;
import placeholder.model.Item;

import java.util.Scanner;

public class Main {
    private static void processGroceries() {
        Groceries groceries = new Groceries();
        Scanner myObj = new Scanner(System.in);

        while (true) {
            System.out.println("Input item's name/quit");
            String iname = myObj.next();
            if (iname.equals("quit")) {
                break;
            }
            System.out.println("Input item's cost");
            double icost = myObj.nextDouble();
            System.out.println("Input item's quantity");
            int iquantity = myObj.nextInt();
            Item item = new Item(iname, icost, iquantity);
            groceries.addItem(item);
        }
        System.out.println("The total cost of this trip: " + groceries.getTotalCost() + " dollars");
    }

    public static void main(String[] args) {
        processGroceries();
    }
}
//    @Override
//    public void load() {
//        try {
//            FileInputStream saveFile = new FileInputStream("saveFile.sav");
//            ObjectInputStream restore = new ObjectInputStream(saveFile);
//            Object obj = restore.readObject();
//        } catch (java.io.FileNotFoundException e) {
//            System.out.println("This is cursed code");
//        } catch (java.lang.ClassNotFoundException e) {
//            System.out.println("Unhelpful Shit");
//        } catch (java.io.IOException e) {
//            System.out.println("Sex and Drujs");
//        }
//    }
//
//    @Override
//    public static void save() throws IOException {
//        FileWriter fileWriter = new FileWriter(("fileName"));
//        PrintWriter printWriter = new PrintWriter((fileWriter));
//        printWriter.print("The total cost of this trip: " + groceries.getTotalCost() + " dollars");
//    }
//}
