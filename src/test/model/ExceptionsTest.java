package model;

import model.Exceptions.BudgetReachedException;
import model.Exceptions.NoBudgetException;
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
        }
    }

    @Test
    public void isWithinBudgetTestNoException() {
        try {
            groceriesListSetTest.isWithinBudget();
        } catch (NoBudgetException e) {
            fail();
        }
    }

}
