package designpatterns.command;

public class RemoteController {

    Command command ;

    public RemoteController(Command command) {
        this.command = command;
    }

    public void pressLightOnButton(){
        command.excecute();
    }
}
