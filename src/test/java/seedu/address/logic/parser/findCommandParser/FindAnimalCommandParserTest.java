package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindAnimalCommand;
import seedu.address.model.animal.NameContainsKeywordsPredicateAnimal;

/**
 * Contains tests for FindAnimalCommandParser.
 */
public class FindAnimalCommandParserTest {

    private FindAnimalCommandParser parser = new FindAnimalCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAnimalCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindAnimalCommand() {
        // no leading and trailing whitespaces
        FindAnimalCommand expectedFindAnimalCommand =
                new FindAnimalCommand(new NameContainsKeywordsPredicateAnimal(Arrays.asList("Whiskers", "Luna")));
        assertParseSuccess(parser, "Whiskers Luna", expectedFindAnimalCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Whiskers \n \t Luna  \t", expectedFindAnimalCommand);
    }

    @Test
    public void parse_singleKeyword_returnsFindAnimalCommand() {
        FindAnimalCommand expectedFindAnimalCommand =
                new FindAnimalCommand(new NameContainsKeywordsPredicateAnimal(Arrays.asList("Simba")));
        assertParseSuccess(parser, "Simba", expectedFindAnimalCommand);
    }

    @Test
    public void parse_multipleKeywords_returnsFindAnimalCommand() {
        FindAnimalCommand expectedFindAnimalCommand =
                new FindAnimalCommand(new NameContainsKeywordsPredicateAnimal(
                        Arrays.asList("Whiskers", "Luna", "Simba", "Bella")));
        assertParseSuccess(parser, "Whiskers Luna Simba Bella", expectedFindAnimalCommand);
    }

    @Test
    public void parse_keywordsWithExtraWhitespace_returnsFindAnimalCommand() {
        // Test with tabs and multiple spaces
        FindAnimalCommand expectedFindAnimalCommand =
                new FindAnimalCommand(new NameContainsKeywordsPredicateAnimal(Arrays.asList("Whiskers", "Luna")));
        assertParseSuccess(parser, "\t  Whiskers   \n  Luna \t ", expectedFindAnimalCommand);
    }

    @Test
    public void parse_mixedCaseKeywords_returnsFindAnimalCommand() {
        FindAnimalCommand expectedFindAnimalCommand =
                new FindAnimalCommand(new NameContainsKeywordsPredicateAnimal(
                        Arrays.asList("wHISkers", "lUNA", "sIMba")));
        assertParseSuccess(parser, "wHISkers lUNA sIMba", expectedFindAnimalCommand);
    }

    @Test
    public void parse_specialCharactersInKeywords_returnsFindAnimalCommand() {
        FindAnimalCommand expectedFindAnimalCommand =
                new FindAnimalCommand(new NameContainsKeywordsPredicateAnimal(
                        Arrays.asList("Mr.Whiskers", "Luna-Belle")));
        assertParseSuccess(parser, "Mr.Whiskers Luna-Belle", expectedFindAnimalCommand);
    }

    @Test
    public void parse_emptyStringAfterTrim_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAnimalCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_onlyWhitespaces_throwsParseException() {
        assertParseFailure(parser, "   \t   \n   ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAnimalCommand.MESSAGE_USAGE));
    }
}
