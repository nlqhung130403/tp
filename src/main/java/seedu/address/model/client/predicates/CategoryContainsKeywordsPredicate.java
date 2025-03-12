package seedu.address.model.client.predicates;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.client.Client;

/**
 * Tests that a {@code Client}'s {@code Category} matches any of the keywords given.
 */
public class CategoryContainsKeywordsPredicate implements Predicate<Client> {
    private final List<String> keywords;

    public CategoryContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Client client) {
        Set<String> categoryStrings = client.getTags()
                .stream()
                .map(tag -> tag.tagName)
                .collect(Collectors.toSet());

        return keywords.stream()
                .anyMatch(keyword -> categoryStrings.stream()
                        .anyMatch(keyword::equalsIgnoreCase));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CategoryContainsKeywordsPredicate)) {
            return false;
        }

        CategoryContainsKeywordsPredicate otherNameContainsKeywordsPredicate =
                (CategoryContainsKeywordsPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
