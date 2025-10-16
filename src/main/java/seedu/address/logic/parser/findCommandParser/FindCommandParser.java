package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new FindCommand object.
 */
public class FindCommandParser implements Parser<FindCommand> {

    @Override
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        String[] typeAndRest = trimmedArgs.split("\\s+", 2);

        if (typeAndRest.length < 2) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        Type type = new Type(typeAndRest[0]);
        String rest = " " + typeAndRest[1];

        if (type.equals(CliSyntax.TYPE_PERSON)) {
            return new FindPersonCommandParser().parse(rest);
        } else if (type.equals(CliSyntax.TYPE_ANIMAL)) {
            return new FindAnimalCommandParser().parse(rest);
        } else {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
    }
}
