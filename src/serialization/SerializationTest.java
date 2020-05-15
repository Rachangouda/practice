package serialization;

import java.io.IOException;

public class SerializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee e = new Employee("Rachan","Nokia", 23.11, "password");


        //SerialDeserialUtils.serialize(e,"emp.ser");
        Employee employee = (Employee) SerialDeserialUtils.deserialize("emp.ser");

        System.out.println(employee.toString());
    }
}
