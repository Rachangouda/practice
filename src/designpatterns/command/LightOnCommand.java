package designpatterns.command;

public class LightOnCommand implements Command {

    public LightOnCommand(Light light) {
        this.light = light;
    }
    Light light;

    @Override
    public void excecute() {
        light.setLightOn(true);
    }
}
