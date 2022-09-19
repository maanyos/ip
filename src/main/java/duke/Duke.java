package duke;

import duke.command.Command;
import duke.command.LoadCommand;
import duke.command.SaveCommand;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;

/**
 * This is Duke
 * Controls high level flow of Duke
 */
public class Duke {

    private Ui ui;
    private TaskList taskList;
    private Storage storage;

    /**
     * Constructs Duke with ui, taskList and storage objects
     */
    public Duke() {
        ui = new Ui();
        taskList = new TaskList();
        storage = new Storage();
    }

    /**
     * Constructs Duke object and attempts to load previous tasks
     */
    public void startDuke() {
        new Duke();
        Command loadCommand = new LoadCommand();
        loadCommand.execute(taskList, ui, storage);
    }

    /**
     * Attempts to save current tasks before exiting Duke
     */
    public void stopDuke() {
        Command saveCommand = new SaveCommand();
        saveCommand.execute(taskList, ui, storage);
    }

    /**
     * Starts Duke
     * Reads and executes command from user until user wants to exit
     * Stops Duke
     * @param args user inputs
     */
    public void main(String[] args) {
        startDuke();

        boolean isProgramFinished = false;
        while (!isProgramFinished) {
            try {
                String input = Ui.input();
                Command command = Parser.parse(input);
                command.execute(taskList, ui, storage);
                isProgramFinished = command.isExitCommand();
            } catch (DukeException e) {
                e.handle();
            }
        }

        stopDuke();
    }
}
