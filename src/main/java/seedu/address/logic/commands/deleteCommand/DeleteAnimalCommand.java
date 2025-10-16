package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.animal.Animal;
import seedu.address.model.animal.AnimalName;

/**
 * Deletes an animal identified using its name from the address book.
 */
public class DeleteAnimalCommand extends DeleteCommand {

    private final AnimalName name;

    /**
     * Creates a DeleteAnimalCommand to delete the animal with the specified {@code name}
     */
    public DeleteAnimalCommand(AnimalName name) {
        requireNonNull(name);
        this.name = name;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Animal> list = model.getFilteredAnimalList();

        Animal animalToDelete = list.stream()
                .filter(animal -> animal.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new CommandException(Messages.MESSAGE_INVALID_ANIMAL_DISPLAYED_NAME));

        model.deleteAnimal(animalToDelete);
        return new CommandResult(String.format(Messages.MESSAGE_DELETED_ANIMAL_SUCCESS,
                Messages.format(animalToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DeleteAnimalCommand)) {
            return false;
        }

        DeleteAnimalCommand otherCommand = (DeleteAnimalCommand) other;
        return name.equals(otherCommand.name);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .toString();
    }
}
