package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddTimeCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;
import seedu.address.model.person.Time;

/**
 * Parses input arguments and creates a new AddTimeCommand object
 */

public class AddTimeCommandParser implements Parser<AddTimeCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddTimeCommand
     * and returns an AddTimeCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddTimeCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_TIME);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_TIME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTimeCommand.MESSAGE_USAGE));
        }

        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Time time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME).get());

        return new AddTimeCommand(name.toString(), time);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    public static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}