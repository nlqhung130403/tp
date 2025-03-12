package stub.model.client;

import seedu.address.model.client.CategoryContainsKeywordsPredicate;
import seedu.address.model.client.Client;

import java.util.List;

/**
 * Returns whatever boolean return value is required for this stub.
 */
public class CategoryContainsKeywordsPredicateStub extends CategoryContainsKeywordsPredicate {
    private final boolean returnValue;

    public CategoryContainsKeywordsPredicateStub(List<String> keywords, boolean returnValue) {
        super(keywords);
        this.returnValue = returnValue;
    }

    @Override
    public boolean test(Client client) {
        return returnValue;
    }

}
