package GeneralTest;

import java.util.Properties;

public class JavaSystemProperties {

    public static void main(String[] args) {

        Properties pro = new Properties();

        System.out.println((System.getenv().get("COMPUTERNAME")));

    }
}


