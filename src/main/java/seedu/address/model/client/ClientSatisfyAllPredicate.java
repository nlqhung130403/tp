package seedu.address.model.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Client} satisfies any of the predicate given.
 */
public class ClientSatisfyAllPredicate implements Predicate<Client> {
    private final List<String> keywords;
    private final List<Predicate<Client>> predicates = new ArrayList<>();

    /**
     * Assembles the list of predicates to test the client with.
     *
     * @param keywords the keywords to pass into the predicates.
     */
    public ClientSatisfyAllPredicate(List<String> keywords) {
        this.keywords = keywords;
        this.predicates.add(new NameContainsKeywordsPredicate(keywords));
        this.predicates.add(new CategoryContainsKeywordsPredicate(keywords));
        this.predicates.add(new ProductPreferenceContainsKeywordsPredicate(keywords));
    }

    /**
     * Initializes the attributes manually for testing.
     * This constructor should not be called anywhere else other than the test files.
     *
     * @param keywords the keywords to pass into the predicates.
     * @param predicates the predicates to test for.
     */
    public ClientSatisfyAllPredicate(List<String> keywords, List<Predicate<Client>> predicates) {
        this.keywords = keywords;
        this.predicates.addAll(predicates);
    }

    @Override
    public boolean test(Client client) {
        return predicates.stream().anyMatch(predicate -> predicate.test(client));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ClientSatisfyAllPredicate)) {
            return false;
        }

        ClientSatisfyAllPredicate otherClientSatisfyAllPredicate =
                (ClientSatisfyAllPredicate) other;
        return keywords.equals(otherClientSatisfyAllPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
