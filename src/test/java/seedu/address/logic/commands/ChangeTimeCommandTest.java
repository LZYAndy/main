package seedu.address.logic.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.NameContainsKeywordsPredicate;

public class ChangeTimeCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void equals() {
        String first = "Alice 0 Bob 0";
        String second = "alice";


        ChangeTimeCommand changeTimeFirstCommand = new ChangeTimeCommand(first);
        ChangeTimeCommand changeTimeSecondCommand = new ChangeTimeCommand(second);

        // same object -> returns true
        assertTrue(changeTimeFirstCommand.equals(changeTimeFirstCommand));

        // same values -> returns true
        ChangeTimeCommand changeTimeCommandCopy = new ChangeTimeCommand(first);
        assertTrue(changeTimeFirstCommand.equals(changeTimeCommandCopy));

        // different types -> returns false
        assertFalse(changeTimeFirstCommand.equals(1));


        // different person -> returns false
        assertFalse(changeTimeFirstCommand.equals(changeTimeSecondCommand));
    }

    @Test
    public void executeZeroKeywordsNoPersonFound() {
        String expectedMessage = String.format("Cannot find the student, please enter valid name");
        ChangeTimeCommand command = new ChangeTimeCommand("Alllice 100 Bob 0");
        assertEquals(expectedMessage, command.execute(model, commandHistory).feedbackToUser);
    }


    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    public NameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new NameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
