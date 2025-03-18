package seedu.address.model.sortcomparators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.HOON;

import org.junit.jupiter.api.Test;

public class FrequencyComparatorTest {

    @Test
    public void equals() {
        TotalPurchaseComparator firstFrequencyComp = new TotalPurchaseComparator();
        TotalPurchaseComparator secondFrequencyComp = new TotalPurchaseComparator();

        // same object -> returns true
        assertTrue(firstFrequencyComp.equals(firstFrequencyComp));

        // different types -> returns false
        assertFalse(firstFrequencyComp.equals(1));

        // null -> returns false
        assertFalse(firstFrequencyComp.equals(null));

        // different object but same comparator type -> returns true
        assertTrue(firstFrequencyComp.equals(secondFrequencyComp));
    }

    @Test
    public void compare_clientFrequency_returnsTrue() {
        TotalPurchaseComparator frequencyComp = new TotalPurchaseComparator();

        // first client has greater frequency and should come first
        assertEquals(-1, frequencyComp.compare(ALICE, HOON));

        // second client has greater frequency and should come first
        assertEquals(1, frequencyComp.compare(FIONA, ALICE));

        // both client has the same frequency
        assertEquals(0, frequencyComp.compare(ELLE, HOON));
    }
}
