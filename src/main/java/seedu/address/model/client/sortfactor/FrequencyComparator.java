package seedu.address.model.client.sortfactor;

import java.util.Comparator;

import seedu.address.model.client.Client;

/**
 * The comparator that sorts by the frequency of clients' product preferences.
 */
public class FrequencyComparator
        implements Comparator<Client> {

    @Override
    public int compare(Client clientA, Client clientB) {
        int clientAFrequency = clientA.getFrequency().frequency;
        int clientBFrequency = clientB.getFrequency().frequency;

        return Integer.compare(clientBFrequency, clientAFrequency);
    }

}
