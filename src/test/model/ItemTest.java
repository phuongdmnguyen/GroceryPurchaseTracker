package model;

import model.items.Grocery;
import model.items.HouseholdItem;
import model.items.Item;
import model.items.Meat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    private Item item1;
    private Item item2;
    private PersonalList personalList1;
    private PersonalList personalList;

    @BeforeEach
    public void runBefore() {
        item1 = new Grocery("milk");
        item2 = new Meat("ground beef");
        personalList = new GroceriesList();
        personalList1 = new GroceriesList();
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
}
