public class ToDo extends Task {

    public ToDo(String name) {
        super(name);
    }

    @Override
    public char taskType() {
        return 'T';
    }


}
