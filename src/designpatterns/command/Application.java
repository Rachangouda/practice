package designpatterns.command;

public class Application {

    public static void main(String[] args) {


        Command command = new LightOnCommand(new Light());
        RemoteController remoteController = new RemoteController(command);

        remoteController.pressLightOnButton();


        TextDocument textDocument = new TextDocument();

        Command openCommand = new OpenCommand(textDocument);

        openCommand.excecute();

    }
}
