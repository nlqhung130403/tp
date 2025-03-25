package seedu.address.model.client;

public enum Priority {

    VIP, PREMIUM, STANDARD;

    public static final String MESSAGE_CONSTRAINTS = "Priority should be either 1, 2 or 3";

    /**
     * Converts an integer value to the corresponding Priority.
     */
    public static Priority fromInt(int value) {
        switch (value) {
            case 3:
                return VIP;
            case 2:
                return PREMIUM;
            case 1:
                return STANDARD;
            default:
                throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
    }

    public static boolean isValidPriority(int value) {
        return value >= 1 && value <= 3;
    }

    public String toString() {
        return this.name();
    }


}
