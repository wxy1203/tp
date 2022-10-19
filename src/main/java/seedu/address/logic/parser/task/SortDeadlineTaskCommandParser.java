package seedu.address.logic.parser.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONTACT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

import java.net.SocketException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.task.MarkTaskCommand;
import seedu.address.logic.commands.task.SortDeadlineTaskCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.TaskParserUtil;
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

//        Index targetIndex;
//
//        try {
//            targetIndex = TaskParserUtil.parseIndex(argMultimap.getPreamble());
//        } catch (ParseException pe) {
//            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkTaskCommand.MESSAGE_USAGE), pe);
//        }

        return new SortDeadlineTaskCommand();
    }

}
