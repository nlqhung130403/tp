package stub.model.client;

import seedu.address.model.client.Client;
import seedu.address.model.client.predicates.NameContainsKeywordsPredicate;

import java.util.List;

/**
 * Returns whatever boolean return value is required for this stub.
 */
public class NameContainsKeywordsPredicateStub extends NameContainsKeywordsPredicate {
    private final boolean returnValue;

    public NameContainsKeywordsPredicateStub(List<String> keywords, boolean returnValue) {
        super(keywords);
        this.returnValue = returnValue;
    }

    @Override
    public boolean test(Client client) {
        return returnValue;
    }

}