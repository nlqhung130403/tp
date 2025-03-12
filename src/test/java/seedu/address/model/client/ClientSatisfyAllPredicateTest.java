package seedu.address.model.client;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import seedu.address.testutil.PersonBuilder;

import org.junit.jupiter.api.Test;
import stub.model.client.CategoryContainsKeywordsPredicateStub;
import stub.model.client.NameContainsKeywordsPredicateStub;
import stub.model.client.ProductPreferenceContainsKeywordsPredicateStub;

public class ClientSatisfyAllPredicateTest {
    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        ClientSatisfyAllPredicate firstPredicate = new ClientSatisfyAllPredicate(firstPredicateKeywordList);
        ClientSatisfyAllPredicate secondPredicate = new ClientSatisfyAllPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        ClientSatisfyAllPredicate firstPredicateCopy = new ClientSatisfyAllPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_clientSatisfyAllPredicate_returnsTrue() {
        NameContainsKeywordsPredicateStub namePredicateStubTrue =
                new NameContainsKeywordsPredicateStub(Collections.singletonList("Alice"), true);

        CategoryContainsKeywordsPredicateStub categoryPredicateStubTrue =
                new CategoryContainsKeywordsPredicateStub(Arrays.asList("business", "friend"), true);
        CategoryContainsKeywordsPredicateStub categoryPredicateStubFalse =
                new CategoryContainsKeywordsPredicateStub(Arrays.asList("business", "friend"), false);

        ProductPreferenceContainsKeywordsPredicateStub productPrefPredicateStubTrue =
                new ProductPreferenceContainsKeywordsPredicateStub(Collections.singletonList("Book"), true);
        ProductPreferenceContainsKeywordsPredicateStub productPrefPredicateStubFalse =
                new ProductPreferenceContainsKeywordsPredicateStub(Collections.singletonList("Book"), false);

        // One predicate true
        ClientSatisfyAllPredicate predicate = new ClientSatisfyAllPredicate(Collections.singletonList("Alice"),
                List.of(namePredicateStubTrue, categoryPredicateStubFalse, productPrefPredicateStubFalse));
        assertTrue(predicate.test(new PersonBuilder().build()));

        // Multiple predicate true
        predicate = new ClientSatisfyAllPredicate(Collections.singletonList("Alice"),
                List.of(namePredicateStubTrue, categoryPredicateStubTrue, productPrefPredicateStubFalse));
        assertTrue(predicate.test(new PersonBuilder().build()));

        predicate = new ClientSatisfyAllPredicate(Collections.singletonList("Alice"),
                List.of(namePredicateStubTrue, categoryPredicateStubTrue, productPrefPredicateStubTrue));
        assertTrue(predicate.test(new PersonBuilder().build()));
    }

    @Test
    public void test_clientSatisfyAllPredicate_returnsFalse() {
        NameContainsKeywordsPredicateStub namePredicateStubFalse =
                new NameContainsKeywordsPredicateStub(Collections.singletonList("Alice"), false);
        CategoryContainsKeywordsPredicateStub categoryPredicateStubFalse =
                new CategoryContainsKeywordsPredicateStub(Arrays.asList("business", "friend"), false);
        ProductPreferenceContainsKeywordsPredicateStub productPrefPredicateStubFalse =
                new ProductPreferenceContainsKeywordsPredicateStub(Collections.singletonList("Book"), false);

        // Zero predicate true
        ClientSatisfyAllPredicate predicate = new ClientSatisfyAllPredicate(Collections.emptyList(),
                List.of(namePredicateStubFalse, categoryPredicateStubFalse, productPrefPredicateStubFalse));
        assertFalse(predicate.test(new PersonBuilder().build()));
    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        ClientSatisfyAllPredicate predicate = new ClientSatisfyAllPredicate(keywords);

        String expected = ClientSatisfyAllPredicate.class.getCanonicalName()
                + "{keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
