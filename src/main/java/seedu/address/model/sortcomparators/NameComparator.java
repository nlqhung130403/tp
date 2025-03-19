package seedu.address.model.sortcomparators;

import java.util.Comparator;

import seedu.address.model.client.Client;

/**
 * The comparator that sorts by the alphabetical order of the clients' name.
 */
public class NameComparator implements Comparator<Client> {

    @Override
    public int compare(Client clientA, Client clientB) {
        String clientAName = clientA.getName().fullName;
        String clientBName = clientB.getName().fullName;

        return clientAName.compareTo(clientBName);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NameComparator)) {
            return false;
        }

        return true;
    }

}
