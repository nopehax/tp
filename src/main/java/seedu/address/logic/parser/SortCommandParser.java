package seedu.address.logic.parser;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.commands.SortCommand.SortBy;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser {
    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns a SortCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortCommand parse(String args) throws ParseException {
        SortBy sort = null;
        SortBy[] methods = SortBy.values();
        args = args.trim().toUpperCase();
        for (SortBy m: methods) {
            if (m.name().equals(args)) {
                sort = m;
            }
        }
        if (sort == null) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }
        return new SortCommand(sort);
    }
}
