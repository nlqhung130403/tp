// ExpandCommand.java
package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.client.Client;

public class ExpandCommand extends Command {
    public static final String COMMAND_WORD = "expand";
    public static final String MESSAGE_EXPAND_CLIENT_SUCCESS = "Expanded view for Client: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Shows detailed view of the client identified by index.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    private final Index targetIndex;

    public ExpandCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Client> filteredList = model.getSortedFilteredClientList();

        if (targetIndex.getZeroBased() >= filteredList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Client clientToExpand = filteredList.get(targetIndex.getZeroBased());
        return new CommandResult(
                String.format(MESSAGE_EXPAND_CLIENT_SUCCESS, clientToExpand.getName()),
                false,
                false,
                true,
                clientToExpand
        );
    }
}
