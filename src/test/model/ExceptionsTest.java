package model;

import model.exceptions.BudgetReachedException;
import model.exceptions.NoBudgetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ExceptionsTest {
    private GroceriesList groceriesListSetTest;
    private MustHaveList musthavesSetTest;


    @BeforeEach
    public void runBefore() {
        groceriesListSetTest = new GroceriesList();
        musthavesSetTest = new MustHaveList();
    }

    @Test
    public void isContainMustHaveExceptionTest() {
        try {
            groceriesListSetTest.isContainMustHaves(musthavesSetTest);
            fail();
        } catch (NoBudgetException e) {
        } catch (BudgetReachedException e) {
            fail();
        }
    }

    @Test
    public void isWithinBudgetTestNoException() {
        groceriesListSetTest.setBudget(10);
        try {
            groceriesListSetTest.isContainMustHaves(musthavesSetTest);
        } catch (BudgetReachedException e) {
            fail("Caught exception not supposed to catch");
        } catch (NoBudgetException e) {
            fail("Exception thrown when shouldn't have");
        }
    }
}

