package model;

import model.items.Item;
import model.items.Meat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalListTest {
    private PersonalList personalList;
    private Item item1;
    private Item item2;
    private Item item1Duplicate;

    @BeforeEach
    public void runBefore() {
        ShoppingListMonitor shoppingListMonitor = new ShoppingListMonitor();
        personalList = new GroceriesList(shoppingListMonitor);
        item1 = new Meat("chicken breasts");
        item1Duplicate = new Meat("chicken breasts");
        item2 = new Meat("frozen pizza");
    }

    @Test
    public void testAddItem() {
        personalList.addItem(item1);
        assertEquals(1,personalList.size());
        personalList.addItem(item1Duplicate);
        assertEquals(1,personalList.size());
    }
}
