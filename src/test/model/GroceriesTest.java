package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class GroceriesTest {
    private Groceries groceriesSetTest;
    private PersonalLists musthavesSetTest;
    private Item beef;
    private Item carrot;
    private Groceries shoppinglistSetTest;

    @BeforeEach
    public void runBefore() {
        groceriesSetTest = new Groceries();
        musthavesSetTest = new PersonalLists();
        shoppinglistSetTest = new Groceries();
        beef = new Meat("beef", 3, 1,10,false);
        carrot = new Produce("carrot", 5, 2, 50, false);
    }

    @Test
    public void testgetItemCost() {
        assertEquals(3, beef.getItemTotalCost());
        assertEquals(10, carrot.getItemTotalCost());
    }

    @Test
    public void testgetTotalCost() {
        groceriesSetTest.addItem(beef);
        groceriesSetTest.addItem(carrot);
        assertEquals(2, groceriesSetTest.size());
        assertEquals(13, groceriesSetTest.getTotalCost());
    }

    @Test
    public void testisWithinBudget() {
        groceriesSetTest.addItem(beef);
        groceriesSetTest.addItem(carrot);
        assertTrue(groceriesSetTest.isWithinBudget());
        Item chocolate = new Meat("chicken", 60, 1,8, false);
        groceriesSetTest.addItem(chocolate);
        assertFalse(groceriesSetTest.isWithinBudget());
    }

    @Test
    public void testCountItem() {
        groceriesSetTest.addItem(beef);
        groceriesSetTest.addItem(carrot);
        assertEquals(2, groceriesSetTest.countItem());
    }

    //Test cases of isContainMustHaves:
    // - groceries contain all items from must have list
    // - groceries contain some items from must have list
    // - groceries contain no items from must have list
    @Test
    public void testContainAllMustHaves() {
        groceriesSetTest.addItem(beef);
        groceriesSetTest.addItem(carrot);
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        Groceries sl = groceriesSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(), sl.countItem());
    }

    @Test
    public void testContainSomeMustHaves() {
        groceriesSetTest.addItem(beef);
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        shoppinglistSetTest.addItem(carrot);
        Groceries sl = groceriesSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(), sl.countItem());
    }

    @Test
    public void testContainNoMustHaves() {
        musthavesSetTest.addItem(beef);
        musthavesSetTest.addItem(carrot);
        shoppinglistSetTest.addItem(beef);
        shoppinglistSetTest.addItem(carrot);
        Groceries sl = groceriesSetTest.isContainMustHaves(musthavesSetTest);
        assertEquals(shoppinglistSetTest.size(), sl.countItem());
    }

    @Test
    public void testMeatExpiry() {
        groceriesSetTest.addItem(beef);
        groceriesSetTest.itemExpired();
        assertFalse(beef.expiryStatus);
    }

    @Test
    public void testProduceExpiry() {
        groceriesSetTest.addItem(carrot);
        groceriesSetTest.itemExpired();
        assertFalse(carrot.expiryStatus);
    }
    
    @Test
    public void testSave() throws IOException {
        groceriesSetTest.addItem(beef);
        groceriesSetTest.save();
        StringWriter out = new StringWriter();
        PrintWriter writer = new PrintWriter(out);
        for (Item i : groceriesSetTest.groceries) {
            writer.print(i.getItemName() + " ");
            writer.print("quantity: " + i.getItemQuantity() + "; ");
            writer.print("total cost:" + i.getItemTotalCost() + "; ");
            writer.println(" ");
        }
        writer.close();
        String result = out.toString();
    }

    @Test
    public void testLoad() throws IOException {
        groceriesSetTest.addItem(beef);
        groceriesSetTest.addItem(carrot);
        FileInputStream output = new FileInputStream("testSave");
        DataInputStream outputs = new DataInputStream(output);
        outputs.readUTF();
        outputs.close();
    }
}