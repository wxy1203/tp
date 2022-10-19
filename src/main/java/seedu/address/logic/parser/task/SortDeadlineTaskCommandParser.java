package seedu.address.logic.parser.task;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.task.SortDeadlineTaskCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortDeadlineTaskCommand object
 */
public class SortDeadlineTaskCommandParser implements Parser<SortDeadlineTaskCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortDeadlineTaskCommand
     * and returns an SortDeadlineTaskCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortDeadlineTaskCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);


        return new SortDeadlineTaskCommand();
    }

}
