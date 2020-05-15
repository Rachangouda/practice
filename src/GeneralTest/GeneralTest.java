package GeneralTest;

import java.util.EnumSet;
import java.util.Set;

public class GeneralTest {

    public static void main(String[] args) {

        System.out.println("Days" + Days.SATURDAY.changedColour());

        try {
            long lTimeMilli = getHeartBeatTimer() * 1000L;
        } catch (Exception e) {
            System.out.println("getmessage: " + e.getMessage());
            System.out.println("getcause:" + e.getCause());
            System.out.println("getLocalizedMessage:" + e.getLocalizedMessage());
            System.out.println("getSuppressed:" + e.getSuppressed());

            //ExceptionUtils
        }
        Set<Days> s = EnumSet.allOf(Days.class);

    }

    private static Long getHeartBeatTimer() {
        return null;
    }
}


enum Ops{
    PLUSE, MINUS;

    public Integer apply(Integer a, Integer b){

        switch (this){

            case MINUS: return (a - b);
        }
throw new AssertionError("un supported");
    }

}


enum Days{

    MONDAY("green"),
    TUESDAY("red"),
    THURSDAY("yello"),
    WEDNESDAY("wew"),
    FRIDAY("wew"),
    SATURDAY("wewwae");

    private final String colour;
    public String change="qwqw";
    Days(String colour){
        this.colour = colour;
    }

    public String changedColour(){

        return this.colour + change;
    }
}