package duke.command;

import duke.storage.Storage;
import duke.Ui;
import duke.exception.DukeException;
import duke.task.TaskList;

public class MarkCommand extends Command {

    private final String arguments;

    public MarkCommand(String arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            int taskNumber = extractTaskNumber(arguments);
            String task = taskList.markAsDone(taskNumber);
            ui.output("Well done. I've marked this task as done:", task);
        } catch (DukeException e) {
            e.handle(ui);
        }
    }

}
