package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ExpandCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parse the input and creates an ExpandCommand
 */
public class ExpandCommandParser implements Parser<ExpandCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a ExpandCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ExpandCommand parse(String args) throws ParseException {
        Index index = ParserUtil.parseIndex(args);
        return new ExpandCommand(index);
    }
}
