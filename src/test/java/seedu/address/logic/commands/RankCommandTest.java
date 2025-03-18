package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.FindCommandTest.preparePredicate;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.GEORGE;
import static seedu.address.testutil.TypicalPersons.getSortedTypicalClients;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.client.Client;
import seedu.address.model.client.predicates.ClientSatisfyAllPredicate;
import seedu.address.model.sortcomparators.TotalPurchaseComparator;


public class RankCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        Comparator<Client> firstComparator = (o1, o2) -> 0;
        Comparator<Client> secondComparator = (o1, o2) -> 0;


        RankCommand rankFirstCommand = new RankCommand(firstComparator);
        RankCommand rankSecondCommand = new RankCommand(secondComparator);

        // same object -> returns true
        assertTrue(rankFirstCommand.equals(rankFirstCommand));

        // same values -> returns true
        RankCommand rankFirstCommandCopy = new RankCommand(firstComparator);
        assertTrue(rankFirstCommand.equals(rankFirstCommandCopy));

        // different types -> returns false
        assertFalse(rankFirstCommand.equals(1));

        // null -> returns false
        assertFalse(rankFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(rankFirstCommand.equals(rankSecondCommand));
    }

    @Test
    public void execute_nonFiltered_success() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 7);
        Comparator<Client> comparator = prepareComparator();
        RankCommand command = new RankCommand(comparator);
        expectedModel.sortFilteredPersonList(comparator);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(getSortedTypicalClients(), model.getSortedFilteredPersonList());
    }

    @Test
    public void execute_filtered_success() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 2);
        Comparator<Client> comparator = prepareComparator();
        RankCommand command = new RankCommand(comparator);

        ClientSatisfyAllPredicate predicate = preparePredicate("coffee");
        model.updateFilteredPersonList(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        expectedModel.sortFilteredPersonList(comparator);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(FIONA, CARL), model.getSortedFilteredPersonList());

        expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        predicate = preparePredicate("Kurz Elle Kunz");
        model.updateFilteredPersonList(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        expectedModel.sortFilteredPersonList(comparator);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(FIONA, ELLE, CARL), model.getSortedFilteredPersonList());

        expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        predicate = preparePredicate("coffee book");
        model.updateFilteredPersonList(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        expectedModel.sortFilteredPersonList(comparator);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(FIONA, CARL, DANIEL), model.getSortedFilteredPersonList());

        expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 5);
        predicate = preparePredicate("cup friends");
        model.updateFilteredPersonList(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        expectedModel.sortFilteredPersonList(comparator);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, FIONA, ELLE, DANIEL), model.getSortedFilteredPersonList());

        expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 4);
        predicate = preparePredicate("fiona shampoo bag");
        model.updateFilteredPersonList(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        expectedModel.sortFilteredPersonList(comparator);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, FIONA, GEORGE), model.getSortedFilteredPersonList());
    }

    @Test
    public void toStringMethod() {
        Comparator<Client> comparator = prepareComparator();
        RankCommand rankCommand = new RankCommand(comparator);
        String expected = RankCommand.class.getCanonicalName() + "{comparator=" + comparator + "}";
        assertEquals(expected, rankCommand.toString());
    }

    /**
     * Returns a {@code FrequencyComparator} for testing.
     */
    public static Comparator<Client> prepareComparator() {
        return new TotalPurchaseComparator();
    }
}
