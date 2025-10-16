package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonName;

/**
 * Contains integration tests (interaction with the Model) for {@code DeletePersonCommand}.
 */
public class DeletePersonCommandTest {

    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validPersonName_success() {
        Person personToDelete = model.getFilteredPersonList().get(0);
        PersonName name = personToDelete.getName();
        DeletePersonCommand deletePersonCommand = new DeletePersonCommand(name);

        String expectedMessage = String.format(Messages.MESSAGE_DELETED_PERSON_SUCCESS,
                Messages.format(personToDelete));

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deletePerson(personToDelete);

        assertCommandSuccess(deletePersonCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidPersonName_throwsCommandException() {
        PersonName nonExistentName = new PersonName("Non Existent Name");
        DeletePersonCommand deletePersonCommand = new DeletePersonCommand(nonExistentName);

        assertCommandFailure(deletePersonCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_NAME);
    }

    @Test
    public void equals() {
        DeletePersonCommand deleteAliceCommand = new DeletePersonCommand(ALICE.getName());
        DeletePersonCommand deleteBensonCommand = new DeletePersonCommand(BENSON.getName());

        // same object -> returns true
        assertTrue(deleteAliceCommand.equals(deleteAliceCommand));

        // same values -> returns true
        DeletePersonCommand deleteAliceCommandCopy = new DeletePersonCommand(ALICE.getName());
        assertTrue(deleteAliceCommand.equals(deleteAliceCommandCopy));

        // different types -> returns false
        assertFalse(deleteAliceCommand.equals(1));

        // null -> returns false
        assertFalse(deleteAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(deleteAliceCommand.equals(deleteBensonCommand));
    }

    @Test
    public void toStringMethod() {
        DeletePersonCommand deleteCommand = new DeletePersonCommand(ALICE.getName());
        String expected = DeletePersonCommand.class.getCanonicalName() + "{name=" + ALICE.getName() + "}";
        assertEquals(expected, deleteCommand.toString());
    }
}
