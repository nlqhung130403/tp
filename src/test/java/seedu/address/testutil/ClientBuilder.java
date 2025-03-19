package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.client.Address;
import seedu.address.model.client.Client;
import seedu.address.model.client.Email;
import seedu.address.model.client.Frequency;
import seedu.address.model.client.Name;
import seedu.address.model.client.Phone;
import seedu.address.model.client.ProductPreference;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Client objects.
 */
public class ClientBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_PRODUCT_PREFERENCE = "Shampoo";
    public static final int DEFAULT_TOTAL_PURCHASE = 0;

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;
    private ProductPreference productPreference;
    private int totalPurchase;

    /**
     * Creates a {@code ClientBuilder} with the default details.
     */
    public ClientBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        totalPurchase = DEFAULT_TOTAL_PURCHASE;

        //TODO: Change Frequency later on
        productPreference = new ProductPreference(DEFAULT_PRODUCT_PREFERENCE, new Frequency(DEFAULT_TOTAL_PURCHASE));

    }

    /**
     * Initializes the ClientBuilder with the data of {@code clientToCopy}.
     */
    public ClientBuilder(Client clientToCopy) {
        name = clientToCopy.getName();
        phone = clientToCopy.getPhone();
        email = clientToCopy.getEmail();
        address = clientToCopy.getAddress();
        tags = new HashSet<>(clientToCopy.getTags());
        productPreference = clientToCopy.getProductPreference();
        totalPurchase = clientToCopy.getTotalPurchase();
    }

    /**
     * Sets the {@code Name} of the {@code Client} that we are building.
     */
    public ClientBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Client} that we are building.
     */
    public ClientBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Client} that we are building.
     */
    public ClientBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Client} that we are building.
     */
    public ClientBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Client} that we are building.
     */
    public ClientBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Product Preference} of the {@code Client} that we are building.
     */
    public ClientBuilder withProductPreference(String productPreference) {
        //TODO: Change totalPurchase later on
        this.productPreference = new ProductPreference(productPreference, new Frequency(totalPurchase));
        return this;
    }

    /**
     * Sets the {@code Frequency} of the {@code Client} that we are building.
     */
    public ClientBuilder withFrequency(int frequency) {
        this.frequency = new Frequency(frequency);
        return this;
    }

    public Client build() {
        return new Client(name, phone, email, address, tags, productPreference);
    }

}
