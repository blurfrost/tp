package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.animal.NameContainsKeywordsPredicateAnimal;

/**
 * Finds and lists all animals in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindAnimalCommand extends FindCommand {

    private final NameContainsKeywordsPredicateAnimal predicate;

    public FindAnimalCommand(NameContainsKeywordsPredicateAnimal predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredAnimalList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_FIND_ANIMAL_SUCCESS, model.getFilteredAnimalList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindAnimalCommand)) {
            return false;
        }

        FindAnimalCommand otherFindCommand = (FindAnimalCommand) other;
        return predicate.equals(otherFindCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
