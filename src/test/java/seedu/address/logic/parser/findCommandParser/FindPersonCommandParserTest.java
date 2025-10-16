package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.model.person.NameContainsKeywordsPredicatePerson;

/**
 * Contains tests for FindPersonCommandParser.
 */
public class FindPersonCommandParserTest {

    private FindPersonCommandParser parser = new FindPersonCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindPersonCommand() {
        // no leading and trailing whitespaces
        FindPersonCommand expectedFindPersonCommand =
                new FindPersonCommand(new NameContainsKeywordsPredicatePerson(Arrays.asList("Alice", "Bob")));
        assertParseSuccess(parser, "Alice Bob", expectedFindPersonCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Alice \n \t Bob  \t", expectedFindPersonCommand);
    }

    @Test
    public void parse_singleKeyword_returnsFindPersonCommand() {
        FindPersonCommand expectedFindPersonCommand =
                new FindPersonCommand(new NameContainsKeywordsPredicatePerson(Arrays.asList("Alice")));
        assertParseSuccess(parser, "Alice", expectedFindPersonCommand);
    }

    @Test
    public void parse_multipleKeywords_returnsFindPersonCommand() {
        FindPersonCommand expectedFindPersonCommand =
                new FindPersonCommand(new NameContainsKeywordsPredicatePerson(
                        Arrays.asList("Alice", "Bob", "Charlie", "Dave")));
        assertParseSuccess(parser, "Alice Bob Charlie Dave", expectedFindPersonCommand);
    }

    @Test
    public void parse_keywordsWithExtraWhitespace_returnsFindPersonCommand() {
        // Test with tabs and multiple spaces
        FindPersonCommand expectedFindPersonCommand =
                new FindPersonCommand(new NameContainsKeywordsPredicatePerson(Arrays.asList("Alice", "Bob")));
        assertParseSuccess(parser, "\t  Alice   \n  Bob \t ", expectedFindPersonCommand);
    }

    @Test
    public void parse_mixedCaseKeywords_returnsFindPersonCommand() {
        FindPersonCommand expectedFindPersonCommand =
                new FindPersonCommand(new NameContainsKeywordsPredicatePerson(
                        Arrays.asList("aLICe", "bOB", "cHARlie")));
        assertParseSuccess(parser, "aLICe bOB cHARlie", expectedFindPersonCommand);
    }

    @Test
    public void parse_specialCharactersInKeywords_returnsFindPersonCommand() {
        FindPersonCommand expectedFindPersonCommand =
                new FindPersonCommand(new NameContainsKeywordsPredicatePerson(
                        Arrays.asList("O'Connor", "Smith-Jones")));
        assertParseSuccess(parser, "O'Connor Smith-Jones", expectedFindPersonCommand);
    }

    @Test
    public void parse_emptyStringAfterTrim_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_onlyWhitespaces_throwsParseException() {
        assertParseFailure(parser, "   \t   \n   ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
    }
}
