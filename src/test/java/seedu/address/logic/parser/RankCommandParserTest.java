package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMPARATOR_KEYWORD;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RankCommand;
import seedu.address.model.sortcomparators.NameComparator;
import seedu.address.model.sortcomparators.TotalPurchaseComparator;


public class RankCommandParserTest {

    private RankCommandParser parser = new RankCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, RankCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "nonsense", MESSAGE_UNKNOWN_COMPARATOR_KEYWORD);

        assertParseFailure(parser, "daA1231asjkdhajkdADJKSdajd", MESSAGE_UNKNOWN_COMPARATOR_KEYWORD);

        // multiple args
        assertParseFailure(parser, TotalPurchaseComparator.COMPARATOR_WORD + " priority",
                MESSAGE_UNKNOWN_COMPARATOR_KEYWORD);
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        RankCommand expectedRankCommand =
                new RankCommand(new TotalPurchaseComparator());
        // no leading and trailing whitespaces
        assertParseSuccess(parser, TotalPurchaseComparator.COMPARATOR_WORD, expectedRankCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n " + TotalPurchaseComparator.COMPARATOR_WORD + " \n \t \t", expectedRankCommand);

        // mixed case keywords
        assertParseSuccess(parser, "tOtAL", expectedRankCommand);

        expectedRankCommand = new RankCommand(new NameComparator());
        // no leading and trailing whitespaces
        assertParseSuccess(parser, NameComparator.COMPARATOR_WORD, expectedRankCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n " + NameComparator.COMPARATOR_WORD + " \n \t \t", expectedRankCommand);

        // mixed case keywords
        assertParseSuccess(parser, "nAMe", expectedRankCommand);
    }

}
