package seedu.address.model.sortcomparators;

import java.util.Comparator;

import seedu.address.model.client.Client;

/**
 * The comparator that sorts by the frequency of clients' product preferences.
 */
public class FrequencyComparator implements Comparator<Client> {
    public static final String COMPARATOR_WORD = "frequency";

    @Override
    public int compare(Client clientA, Client clientB) {
        int clientAFrequency = clientA.getFrequency().frequency;
        int clientBFrequency = clientB.getFrequency().frequency;

        return Integer.compare(clientBFrequency, clientAFrequency);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FrequencyComparator)) {
            return false;
        }

        return true;
    }

}
