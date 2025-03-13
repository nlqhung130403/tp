package seedu.address.model.client;

/**
 * Represents a Client's product preference in the address book.
 */
public class ProductPreference {
    public final String productPreference;

    public ProductPreference(String productPreference) {
        this.productPreference = productPreference;
    }

    @Override
    public String toString() {
        return productPreference;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ProductPreference)) {
            return false;
        }

        ProductPreference otherProductPreference = (ProductPreference) other;
        return productPreference.trim().equalsIgnoreCase(otherProductPreference.productPreference.trim());
    }

    @Override
    public int hashCode() {
        return productPreference.hashCode();
    }

}
