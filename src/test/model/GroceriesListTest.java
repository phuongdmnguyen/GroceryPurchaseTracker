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

import static org.junit.jupiter.api.Assertions.*;

class GroceriesListTest {
    private GroceriesList groceriesListSetTest;
    private MustHaveList musthavesSetTest;
    private Item beef;
    private Item carrot;
    private GroceriesList shoppinglistSetTest;
    private PersonalSettings personalSettings;

    @BeforeEach
    public void runBefore() {
        groceriesListSetTest = new GroceriesList();
        musthavesSetTest = new MustHaveList();
        shoppinglistSetTest = new GroceriesList();
        beef = new Meat("beef");
        beef.setCost(3);
        beef.setQuantity(1);
        carrot = new Produce("carrot");
        carrot.setCost(5);
        carrot.setQuantity(2);
        personalSettings = new PersonalSettings();
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
    public void testContainAllMustHaves(){
        groceriesListSetTest.addItem(beef);
        groceriesListSetTest.addItem(carrot);
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        try {
            GroceriesList sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
            assertEquals(shoppinglistSetTest.size(), sl.countItem());

        } catch (NoBudgetException e) {
            fail();
        } catch (BudgetReachedException e) {
            fail();
        }
    }

    @Test
    public void testContainSomeMustHaves(){
        groceriesListSetTest.addItem(beef);
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        shoppinglistSetTest.addItem(carrot);
        try {
            GroceriesList sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
            assertEquals(shoppinglistSetTest.size(), sl.countItem());

        } catch (NoBudgetException e) {
            fail();
        } catch (BudgetReachedException e) {
            fail();
        }
    }

    @Test
    public void testContainNoMustHaves() {
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        shoppinglistSetTest.addItem(beef);
        shoppinglistSetTest.addItem(carrot);
        personalSettings.setBudget(30);
        try {
            GroceriesList sl = groceriesListSetTest.isContainMustHaves(musthavesSetTest);
            assertEquals(shoppinglistSetTest.size(), sl.countItem());

        } catch (NoBudgetException e) {
            fail();
        } catch (BudgetReachedException e) {
            fail();
        }
    }

        @Test
        public void testIsNotWithinBudget () {
            shoppinglistSetTest.addItem(beef);
            shoppinglistSetTest.addItem(carrot);
            personalSettings.setBudget(10);
            assertFalse(shoppinglistSetTest.isWithinBudget());
        }

        @Test
        public void testIsWithinBudget () {
            shoppinglistSetTest.addItem(beef);
            shoppinglistSetTest.addItem(carrot);
            personalSettings.setBudget(20);
            assertTrue(shoppinglistSetTest.isWithinBudget());
        }


        @Test
        public void testSave () throws IOException {
            groceriesListSetTest.addItem(beef);
            groceriesListSetTest.save();
            assertEquals(beef, groceriesListSetTest.load());
        }
    }