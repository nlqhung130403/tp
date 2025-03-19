package seedu.address.model.sortcomparators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.ELLE;
import static seedu.address.testutil.TypicalClients.FIONA;
import static seedu.address.testutil.TypicalClients.HOON;

import org.junit.jupiter.api.Test;

public class TotalPurchaseComparatorTest {

    @Test
    public void equals() {
        TotalPurchaseComparator firstComp = new TotalPurchaseComparator();
        TotalPurchaseComparator secondComp = new TotalPurchaseComparator();

        // same object -> returns true
        assertTrue(firstComp.equals(firstComp));

        // different types -> returns false
        assertFalse(firstComp.equals(1));

        // null -> returns false
        assertFalse(firstComp.equals(null));

        // different object but same comparator type -> returns true
        assertTrue(firstComp.equals(secondComp));
    }

    @Test
    public void compare_clientTotalPurchase_returnsTrue() {
        TotalPurchaseComparator comparator = new TotalPurchaseComparator();

        // first client has greater frequency and should come first
        assertTrue(comparator.compare(ALICE, HOON) < 0);

        // second client has greater frequency and should come first
        assertTrue(comparator.compare(FIONA, ALICE) > 0);

        // both client has the same frequency
        assertEquals(0, comparator.compare(ELLE, HOON));
    }

}
