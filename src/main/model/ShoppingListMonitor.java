package model;

import java.util.Observable;
import java.util.Observer;

public class ShoppingListMonitor implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("A new item has been added to your shopping list");
    }
}
