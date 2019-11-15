package model;

import model.exceptions.BudgetReachedException;
import model.exceptions.NoBudgetException;
import model.items.Grocery;
import model.items.Item;
import model.items.Meat;
import model.items.Produce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.PersonalSettings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroceriesListTest {
    private GroceriesList groceriesListSetTest;
    private MustHaveList musthavesSetTest;
    private Item beef;
    private Item carrot;
    private ArrayList<String> shoppinglistSetTest;

    @BeforeEach
    public void runBefore() {
        ShoppingListMonitor shoppingListMonitor = new ShoppingListMonitor();
        groceriesListSetTest = new GroceriesList(shoppingListMonitor);
        musthavesSetTest = new MustHaveList();
        shoppinglistSetTest = new ArrayList<>();
        beef = new Meat("beef");
        beef.setCost(3);
        beef.setQuantity(1);
        carrot = new Produce("carrot");
        carrot.setCost(5);
        carrot.setQuantity(2);
    }

    @Test
    public void testgetItemCost() {
        assertEquals(3, beef.getItemTotalCost());
        assertEquals(10, carrot.getItemTotalCost());
    }

    @Test
    public void testgetTotalCost() {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.addItem(carrot);
        assertEquals(2, groceriesListSetTest.size());
        assertEquals(13, groceriesListSetTest.getTotalCost());
    }

    @Test
    public void testisWithinBudget() {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.addItem(carrot);
        groceriesListSetTest.setBudget(60);
        assertTrue(groceriesListSetTest.isWithinBudget());
        Item chocolate = new Grocery("chocolate");
        chocolate.setCost(60);
        chocolate.setQuantity(1);
        groceriesListSetTest.addItem(chocolate);
        assertFalse(groceriesListSetTest.isWithinBudget());
    }

    @Test
    public void testCountItem() {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.addItem(carrot);
        assertEquals(2, groceriesListSetTest.countItem());
    }

    //Test cases of isContainMustHaves:
    // - groceries contain all items from must have list
    // - groceries contain some items from must have list
    // - groceries contain no items from must have list
    @Test
    public void testContainAllMustHaves() {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.addItem(carrot);
        musthavesSetTest.addItemToMHList("beef");
        musthavesSetTest.addItemToMHList("carrot");
        try {
            ArrayList<String> sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
            assertEquals(0, sl.size());
            assertEquals("beef", sl.get(0));

        } catch (NoBudgetException e) {
            ;
        } catch (BudgetReachedException e) {
            ;
        }
    }

    @Test
    public void testContainSomeMustHaves() {
        groceriesListSetTest.addItem(beef);
        musthavesSetTest.addItemToMHList("beef");
        musthavesSetTest.addItemToMHList("carrot");
        shoppinglistSetTest.add("carrot");
        try {
            ArrayList<String> sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
            assertEquals(shoppinglistSetTest.size(), sl.size());
            assertEquals("carrot", sl.get(0));

        } catch (NoBudgetException e) {
        } catch (BudgetReachedException e) {
            ;
        }
    }

    @Test
    public void testContainNoMustHaves() {
        musthavesSetTest.addItemToMHList("beef");
        musthavesSetTest.addItemToMHList("carrot");
        shoppinglistSetTest.add("beef");
        shoppinglistSetTest.add("carrot");
        groceriesListSetTest.setBudget(30);
        try {
            ArrayList<String> sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
            assertEquals(shoppinglistSetTest.size(), sl.size());

        } catch (NoBudgetException e) {
            fail();
        } catch (BudgetReachedException e) {
            fail();
        }
    }

    @Test
    public void testgetNamesofItemsInGroceryList() {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.addItem(carrot);
        ArrayList<String> list = groceriesListSetTest.getNamesofItemsInGroceryList(groceriesListSetTest);
        assertEquals(2,list.size());
        assertEquals("beef",list.get(0));
        assertEquals("carrot",list.get(1));

    }


    @Test
    public void testSaveAndLoad() throws IOException {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.save();
        assertEquals(groceriesListSetTest.itemsList, groceriesListSetTest.load());
    }
}