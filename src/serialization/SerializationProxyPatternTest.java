package serialization;

import java.io.IOException;

public class SerializationProxyPatternTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerializationProxyPattern data = new SerializationProxyPattern("xyz");


        SerialDeserialUtils.serialize(data,"proxy.ser");
        SerializationProxyPattern ser = (SerializationProxyPattern)SerialDeserialUtils.deserialize("proxy.ser");

        System.out.println(ser.toString());
    }
}
