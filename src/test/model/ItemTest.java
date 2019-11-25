package model;

import model.items.Grocery;
import model.items.HouseholdItem;
import model.items.Item;
import model.items.Meat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.StyleSheet;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item item1;
    private Item item2;
    private PersonalList personalList1;
    private PersonalList personalList;

    @BeforeEach
    public void runBefore() {
        ShoppingListMonitor shoppingListMonitor = new ShoppingListMonitor();
        item1 = new Grocery("milk");
        item1.setQuantity(2);
        item1.setCost(4);
        item2 = new Meat("ground beef");
        personalList = new GroceriesList(shoppingListMonitor);
        personalList1 = new GroceriesList(shoppingListMonitor);
    }

    @Test
    public void testGetters() {
        assertEquals("milk",item1.getItemName());
        assertEquals(2,item1.getItemQuantity());
        assertEquals(4,item1.getItemCost());
    }

    @Test
    public void testAssignToList() {
        item1.assignToList(personalList);
        assertEquals(1,personalList.size());
        assertEquals(1,item1.getPersonalLists().size());
    }

    @Test
    public void testAssignManyListsToItem() {
        item1.assignToList(personalList1);
        item1.assignToList(personalList);
        assertEquals(2,item1.getPersonalLists().size());
        assertEquals(personalList,item1.getPersonalLists().get(1));
    }

    @Test
    public void testPutItemInCategory() {
        item1.putItemIntoCategory();

    }

    @Test
    public void testNotEqualsDifferentCategory() {
        assertFalse(item1.equals(item2));
    }

    @Test
    public void testNotEqualDifferentName() {
        Item item = new Meat("chicken");
        assertFalse(item.equals(item2));
    }

    @Test
    public void testEqual() {
        Item item = new Meat("ground beef");
        assertTrue(item.equals(item2));
        assertEquals(item.hashCode(),item2.hashCode());
    }
}
