package seedu.address.model.client;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Client} satisfies any of the predicate given.
 */
public class ClientSatisfyAllPredicate implements Predicate<Client> {
    private final List<String> keywords;

    public ClientSatisfyAllPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Client client) {
        NameContainsKeywordsPredicate nameContainsKeywordsPredicate =
                new NameContainsKeywordsPredicate(keywords);
        CategoryContainsKeywordsPredicate categoryContainsKeywordsPredicate =
                new CategoryContainsKeywordsPredicate(keywords);
        ProductPreferenceContainsKeywordsPredicate productPreferenceContainsKeywordsPredicate =
                new ProductPreferenceContainsKeywordsPredicate(keywords);

        return nameContainsKeywordsPredicate.test(client)
                || categoryContainsKeywordsPredicate.test(client)
                || productPreferenceContainsKeywordsPredicate.test(client);
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
