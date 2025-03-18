// ClientDetailPanel.java
package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.model.client.Client;

public class ClientDetailPanel extends UiPart<Region> {
    private static final String FXML = "ClientDetailPanel.fxml";

    @FXML private Label name;
    @FXML private Label phone;
    @FXML private Label email;
    @FXML private Label address;
    @FXML private Label frequency;
    @FXML private Label productPreference;

    public ClientDetailPanel(Client client) {
        super(FXML);
        name.setText(client.getName().fullName);
        phone.setText("Phone: " + client.getPhone().value);
        email.setText("Email: " + client.getEmail().value);
        address.setText("Address: " + client.getAddress().value);
        frequency.setText("Purchase Frequency: " + client.getFrequency());
        productPreference.setText("Preferred Products: " + client.getProductPreference());
    }
}