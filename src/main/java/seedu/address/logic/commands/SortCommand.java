package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;
import seedu.address.model.Model.ListType;

/**
 * Sorts the current list according to oldest to newest, alphabetically, or reverse order.
 */
public class SortCommand extends Command {

    public enum SortBy { DEFAULT, ALPHA, REVERSE }

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + "[default/alpha/reverse]";

    public static final String MESSAGE_SUCCESS = "List sorted %s";

    private static final String DEFAULT_SORT_SUCCESS = "from oldest to newest entry";
    private static final String ALPHA_SORT_SUCCESS = "alphabetically";
    private static final String REVERSE_SORT_SUCCESS = "in reverse order";

    private SortBy method;
    private String successMsg;

    public SortCommand(SortBy method) {
        this.method = method;
        switch (method) {
        case DEFAULT:
            this.successMsg = DEFAULT_SORT_SUCCESS;
            break;
        case ALPHA:
            this.successMsg = ALPHA_SORT_SUCCESS;
            break;
        case REVERSE:
            this.successMsg = REVERSE_SORT_SUCCESS;
            break;
        default:
            this.successMsg = "?";
        }
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        ListType type = model.getCurrentListType();
        model.sortList(type, this.method);
        return new CommandResult(String.format(MESSAGE_SUCCESS, this.successMsg), true);
    }
}