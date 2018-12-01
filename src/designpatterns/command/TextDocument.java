package designpatterns.command;

public class TextDocument implements Document {
    @Override
    public void open() {
        System.out.print("Opened text document.");
    }

    @Override
    public void close() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void save() {

    }
}
