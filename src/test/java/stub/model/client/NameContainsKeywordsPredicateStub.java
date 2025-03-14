package stub.model.client;

import java.util.List;

import seedu.address.model.client.Client;
import seedu.address.model.client.predicates.NameContainsKeywordsPredicate;


/**
 * Returns whatever boolean return value is required for this stub.
 */
public class NameContainsKeywordsPredicateStub extends NameContainsKeywordsPredicate {
    private final boolean returnValue;

    /**
     * Initializes the stub for the NameContainsKeywordsPredicate class.
     *
     * @param keywords the keywords to find.
     * @param returnValue the defined return value when tested.
     */
    public NameContainsKeywordsPredicateStub(List<String> keywords, boolean returnValue) {
        super(keywords);
        this.returnValue = returnValue;
    }

    @Override
    public boolean test(Client client) {
        return returnValue;
    }
}
