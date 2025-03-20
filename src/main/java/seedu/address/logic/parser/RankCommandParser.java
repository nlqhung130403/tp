package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMPARATOR_KEYWORD;

import java.util.Comparator;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.RankCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.client.Client;
import seedu.address.model.sortcomparators.NameComparator;
import seedu.address.model.sortcomparators.TotalPurchaseComparator;

/**
 * Parses input arguments and creates a new RankCommand object
 */
public class RankCommandParser implements Parser<Command> {

    /**
     * Parses the given {@code String} of arguments in the context of the RankCommand
     * and returns a RankCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RankCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, RankCommand.MESSAGE_USAGE));
        }

        Comparator<Client> comparator = parseRankKeywords(trimmedArgs);

        return new RankCommand(comparator);
    }

    /**
     * Parses the keywords that follow after the rank command word.
     * This method is case-insensitive but other than that must match the comparator keyword exactly.
     *
     * @param keyword The keyword to check for suitable comparator.
     * @return the suitable comparator to compare each client entry in the list if a matching keyword is found.
     * @throws ParseException if no matching keyword is found.
     */
    private Comparator<Client> parseRankKeywords(String keyword) throws ParseException {
        keyword = keyword.toLowerCase();
        switch (keyword) {
        case TotalPurchaseComparator.COMPARATOR_WORD:
            return new TotalPurchaseComparator();

        case NameComparator.COMPARATOR_WORD:
            return new NameComparator();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMPARATOR_KEYWORD);
        }
    }

}
