package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.client.Client;
import seedu.address.model.client.predicates.ClientSatisfyAllPredicate;

/**
 * Ranks the current updated list of clients based on a key factor.
 */
public class RankCommand extends Command {

    public static final String COMMAND_WORD = "rank";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Ranks all clients based on "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " frequency";

    private final ClientSatisfyAllPredicate factor;

    public RankCommand(ClientSatisfyAllPredicate factor) {
        this.factor = factor;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        ObservableList<Client> currentClientList = model.getFilteredPersonList();
        currentClientList.sorted();
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RankCommand)) {
            return false;
        }

        RankCommand otherRankCommand = (RankCommand) other;
        return predicate.equals(otherRankCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
