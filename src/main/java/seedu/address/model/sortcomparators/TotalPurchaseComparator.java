package seedu.address.model.sortcomparators;

import java.util.Comparator;

import seedu.address.model.client.Client;

/**
 * The comparator that sorts by the total purchase of clients' product preferences.
 */
public class TotalPurchaseComparator implements Comparator<Client> {
    public static final String COMPARATOR_WORD = "total";

    /**
     * Compares two clients based on their totalPurchase.
     * This comparison is done in descending order.
     *
     * @param clientA the first client to be compared.
     * @param clientB the second client to be compared.
     * @return -1 if clientA has greater total purchase, 0 if both are the same,
     *         and 1 if clientB has greater total purchase.
     */
    @Override
    public int compare(Client clientA, Client clientB) {
        int clientATotalPurchase = clientA.getTotalPurchase();
        int clientBTotalPurchase = clientB.getTotalPurchase();

        return Integer.compare(clientBTotalPurchase, clientATotalPurchase);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TotalPurchaseComparator)) {
            return false;
        }

        return true;
    }

}
