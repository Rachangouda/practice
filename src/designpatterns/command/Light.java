package designpatterns.command;

//receiver on which action are done
public class Light {

    boolean lightOn = false;

    public boolean isLightOn() {
        return lightOn;
    }

    public void setLightOn(boolean lightOn) {
        this.lightOn = lightOn;
    }
}
