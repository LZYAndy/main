package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FilterByEducationCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * fiterByEducation.
 */
public class FilterByEducationCommandParser implements Parser<FilterByEducationCommand> {
    /**
     * FilterByGradeCommand
     * @param args
     * @return
     * @throws ParseException
     */
    public FilterByEducationCommand parse(String args) throws ParseException {


        String stringCommand = args.trim();
        if (stringCommand.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterByEducationCommand.MESSAGE_USAGE));
        }
        if (!("pri".equals(stringCommand) || "sec".equals(stringCommand) || "jc".equals(stringCommand))) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterByEducationCommand.MESSAGE_USAGE));

        }
        return new FilterByEducationCommand(stringCommand);
    }
}