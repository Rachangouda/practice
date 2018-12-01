package designpatterns.command;

public class OpenCommand implements Command {

    protected Document receiver;

    public OpenCommand(Document receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excecute() {
        receiver.open();
    }
}
