package seedu.address.model.sortcomparators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.FIONA;
import static seedu.address.testutil.TypicalClients.HOON;

import org.junit.jupiter.api.Test;

public class NameComparatorTest {

    @Test
    public void equals() {
        NameComparator firstComp = new NameComparator();
        NameComparator secondComp = new NameComparator();

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
    public void compare_clientName_returnsTrue() {
        NameComparator comparator = new NameComparator();

        // first client is greater lexicographically and should come first
        assertTrue(comparator.compare(ALICE, HOON) < 0);

        // second client is greater lexicographically and should come first
        assertTrue(comparator.compare(FIONA, ALICE) > 0);

        // both client has the same name
        assertEquals(0, comparator.compare(HOON, HOON));
    }

}
