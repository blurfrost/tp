package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.TYPE_ANIMAL;
import static seedu.address.logic.parser.CliSyntax.TYPE_PERSON;

/**
 * Finds and lists all persons or animals in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public abstract class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons/animals whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "1. To find a person:\n"
            + "Example: " + COMMAND_WORD + " "
            + TYPE_PERSON + " luna bob"
            + "\n\n"
            + "2. To find an animal:\n"
            + "Example: " + COMMAND_WORD + " "
            + TYPE_ANIMAL + " alice peter";
}
