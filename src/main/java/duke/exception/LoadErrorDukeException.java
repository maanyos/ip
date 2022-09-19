package duke.exception;

import duke.Ui;

public class LoadErrorDukeException extends DukeException{

    public LoadErrorDukeException() {
    }

    @Override
    public void handle(Ui ui){
        ui.output("Error with loading task");
    }
}
