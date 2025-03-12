package stub.model.client;

import seedu.address.model.client.Client;
import seedu.address.model.client.ProductPreferenceContainsKeywordsPredicate;

import java.util.List;

/**
 * Returns whatever boolean return value is required for this stub.
 */
public class ProductPreferenceContainsKeywordsPredicateStub extends ProductPreferenceContainsKeywordsPredicate {
    private final boolean returnValue;

    public ProductPreferenceContainsKeywordsPredicateStub(List<String> keywords, boolean returnValue) {
        super(keywords);
        this.returnValue = returnValue;
    }

    @Override
    public boolean test(Client client) {
        return returnValue;
    }

}
