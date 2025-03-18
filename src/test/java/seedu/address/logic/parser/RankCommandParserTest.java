package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMPARATOR_KEYWORD;
import static seedu.address.logic.commands.RankCommandTest.prepareComparator;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RankCommand;


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
        assertParseFailure(parser, "frequency priority", MESSAGE_UNKNOWN_COMPARATOR_KEYWORD);
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        RankCommand expectedRankCommand =
                new RankCommand(prepareComparator());
        assertParseSuccess(parser, "frequency", expectedRankCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n frequency \n \t \t", expectedRankCommand);

        // mixed case keywords
        assertParseSuccess(parser, "fReqUEncY", expectedRankCommand);
    }
}
