package placeholder.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.model.Groceries;
import placeholder.model.Item;
import placeholder.model.PersonalLists;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GroceriesTest {
    private Groceries groceriesSetTest;
    private PersonalLists musthavesSetTest;
    private Item egg;
    private Item milk;
    private Groceries shoppinglistSetTest;

    @BeforeEach
    public void runBefore() {
        groceriesSetTest = new Groceries();
        musthavesSetTest = new PersonalLists();
        shoppinglistSetTest = new Groceries();
        egg = new Item("egg",3,1);
        milk = new Item("milk",5,2);
    }

    @Test
    public void testgetItemCost() {
        assertEquals(3, egg.getItemTotalCost());
        assertEquals(10,milk.getItemTotalCost());
    }

    @Test
    public void testgetTotalCost(){
        groceriesSetTest.addItem(egg);
        groceriesSetTest.addItem(milk);
        assertEquals(2,groceriesSetTest.size());
        assertEquals(13,groceriesSetTest.getTotalCost());
    }

    @Test
    public void testisWithinBudget() {
        groceriesSetTest.addItem(egg);
        groceriesSetTest.addItem(milk);
        assertTrue(groceriesSetTest.isWithinBudget());
        Item chocolate = new Item("chocolate", 60,1);
        groceriesSetTest.addItem(chocolate);
        assertFalse(groceriesSetTest.isWithinBudget());
    }

    @Test
    public void testCountItem() {
        groceriesSetTest.addItem(egg);
        groceriesSetTest.addItem(milk);
        assertEquals(2,groceriesSetTest.countItem());
    }

    //Test cases of isContainMustHaves:
    // - groceries contain all items from must have list
    // - groceries contain some items from must have list
    // - groceries contain no items from must have list
    @Test
    public void testContainAllMustHaves() {
        groceriesSetTest.addItem(egg);
        groceriesSetTest.addItem(milk);
        musthavesSetTest.addItem(egg);
        musthavesSetTest.addItem(milk);
        Groceries sl = groceriesSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(),sl.countItem());
    }

    @Test
    public void testContainSomeMustHaves() {
        groceriesSetTest.addItem(egg);
        musthavesSetTest.addItem(egg);
        musthavesSetTest.addItem(milk);
        shoppinglistSetTest.addItem(milk);
        Groceries sl = groceriesSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(),sl.countItem());
    }

    @Test
    public void testContainNoMustHaves() {
        musthavesSetTest.addItem(egg);
        musthavesSetTest.addItem(milk);
        shoppinglistSetTest.addItem(egg);
        shoppinglistSetTest.addItem(milk);
        Groceries sl = groceriesSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(),sl.countItem());
    }

    @Test
    public void testSave() throws IOException {
        groceriesSetTest.addItem(egg);
        groceriesSetTest.addItem(milk);
    }

    @Test
    public void testLoad() throws IOException {
        groceriesSetTest.addItem(egg);
        groceriesSetTest.addItem(milk);
    }
}