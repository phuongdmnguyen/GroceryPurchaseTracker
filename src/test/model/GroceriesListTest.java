package model;

import model.exceptions.BudgetReachedException;
import model.exceptions.NoBudgetException;
import model.items.Item;
import model.items.Meat;
import model.items.Produce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class GroceriesListTest {
    private GroceriesList groceriesListSetTest;
    private MustHaveList musthavesSetTest;
    private Item beef;
    private Item carrot;
    private GroceriesList shoppinglistSetTest;

    @BeforeEach
    public void runBefore() {
        groceriesListSetTest = new GroceriesList();
        musthavesSetTest = new MustHaveList();
        shoppinglistSetTest = new GroceriesList();
        beef = new Meat("beef", 3, 1);
        carrot = new Produce("carrot", 5, 2);
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
        assertTrue(groceriesListSetTest.isWithinBudget());
        Item chocolate = new Meat("chicken", 60, 1);
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
    public void testContainAllMustHaves() throws BudgetReachedException, NoBudgetException {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.addItem(carrot);
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        GroceriesList sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(), sl.countItem());
    }

    @Test
    public void testContainSomeMustHaves() throws BudgetReachedException, NoBudgetException {
        groceriesListSetTest.addItem(beef);
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        shoppinglistSetTest.addItem(carrot);
        GroceriesList sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(), sl.countItem());
    }

    @Test
    public void testContainNoMustHaves() throws BudgetReachedException, NoBudgetException {
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        shoppinglistSetTest.addItem(beef);
        shoppinglistSetTest.addItem(carrot);
        GroceriesList sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(), sl.countItem());
    }



    @Test
    public void testSave() throws IOException {
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.save();

        assertEquals(beef, groceriesListSetTest.load());
    }
}