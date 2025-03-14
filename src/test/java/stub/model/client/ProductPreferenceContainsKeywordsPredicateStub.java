package stub.model.client;

import java.util.List;

import seedu.address.model.client.Client;
import seedu.address.model.client.predicates.ProductPreferenceContainsKeywordsPredicate;


/**
 * Returns whatever boolean return value is required for this stub.
 */
public class ProductPreferenceContainsKeywordsPredicateStub extends ProductPreferenceContainsKeywordsPredicate {
    private final boolean returnValue;

    /**
     * Initializes the stub for the ProductPreferenceContainsKeywordsPredicate class.
     *
     * @param keywords the keywords to find.
     * @param returnValue the defined return value when tested.
     */
    public ProductPreferenceContainsKeywordsPredicateStub(List<String> keywords, boolean returnValue) {
        super(keywords);
        this.returnValue = returnValue;
    }

    @Override
    public boolean test(Client client) {
        return returnValue;
    }
}
