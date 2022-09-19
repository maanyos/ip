package duke.task;

import duke.exception.DukeException;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event extends Task {

    private final LocalDate date;
    private final LocalTime time;

    public Event(String arguments) throws DukeException {
        super(arguments);
        String dateTime = TaskDateTimeParser.extractTaskDateTime(arguments);
        this.date = TaskDateTimeParser.extractTaskDate(dateTime);
        this.time = TaskDateTimeParser.extractTaskTime(dateTime);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateTime() {
        return TaskDateTimeParser.getDateTime(date, time);
    }

    private String listDateTime() {
        return TaskDateTimeParser.listDateTime(date, time);
    }

    @Override
    public char taskType() {
        return 'E';
    }

    @Override
    public String listTask() {
        return String.format("%s (%s)", super.listTask(), listDateTime());
    }
}
