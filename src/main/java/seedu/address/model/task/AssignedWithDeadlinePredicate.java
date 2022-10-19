package seedu.address.model.task;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Task}'s assigned contacts contains a specified set of contacts.
 */
public class AssignedWithDeadlinePredicate implements Predicate<Task> {

    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Constructs an AssignedToContactsPredicate.
     * @param model the model to use when looking for contacts
     */
    public AssignedWithDeadlinePredicate(Model model) {


        List<Task> lastShownTaskList = model.getFilteredTaskList();

        for (Task task : lastShownTaskList) {
            if (task.getDeadline().isUnspecified()) {
                continue;
            }
            Task t = new Task (task.getTitle(), task.getCompleted(), task.getDeadline(), task.getAssignedContacts());
            this.tasks.add(t);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }


    @Override
    public boolean test(Task task) {
        return tasks.contains(task);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AssignedWithDeadlinePredicate // instanceof handles nulls
                && tasks.equals(((AssignedWithDeadlinePredicate) other).tasks)); // state check
    }
}
