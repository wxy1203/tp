package seedu.address.logic.commands.task;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.TaskCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.AssignedWithDeadlinePredicate;
import seedu.address.model.task.Task;

/**
 * Lists sorted tasks in the task panel to the user in chronological order.
 */
public class SortDeadlineTaskCommand extends TaskCommand {

    public static final String COMMAND_WORD = "sortddl";
    public static final String COMMAND_WORD_FULL = TaskCommand.COMMAND_WORD + " " + COMMAND_WORD;

    public static final String MESSAGE_USAGE = COMMAND_WORD_FULL
            + ": Lists sorted tasks in chronological order.\n"
            + "Example: " + COMMAND_WORD_FULL + " ";

    public static final String MESSAGE_SUCCESS = "%1$s tasks are sorted in chronological order by their deadlines";

    private static ArrayList<Task> tasks;

    private static Logger logger = Logger.getLogger("testDemo");


    /**
     * Creates a SortDeadlineTasksCommand to list the {@code Task}s
     * with the chronological order of deadlines
     */
    public SortDeadlineTaskCommand() {
        this.tasks = new ArrayList();

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);


        Predicate deadlinePredicate = new AssignedWithDeadlinePredicate(model);

        model.updateFilteredTaskList(deadlinePredicate);

        logger.warning("hello world");

        return new CommandResult(String.format(MESSAGE_SUCCESS, model.getFilteredTaskList().size()));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SortDeadlineTaskCommand)) {
            return false;
        }

        // state check
        SortDeadlineTaskCommand e = (SortDeadlineTaskCommand) other;
        return tasks.equals(e.tasks);
    }

    private boolean setIndexEquals(Set<Index> firstSet, Set<Index> secondSet) {
        if (firstSet.size() != secondSet.size()) {
            return false;
        }

        Set<Integer> firstSetValues = firstSet.stream().map(Index::getZeroBased).collect(Collectors.toSet());
        Set<Integer> secondSetValues = secondSet.stream().map(Index::getZeroBased).collect(Collectors.toSet());

        return firstSetValues.equals(secondSetValues);
    }
}
