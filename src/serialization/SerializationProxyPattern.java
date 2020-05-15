package serialization;

import javax.xml.crypto.Data;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerializationProxyPattern implements Serializable {

    private static final long serialVersionUID=8333905273185436744L;

    String data;

    @Override
    public String toString() {
        return "SerializationProxyPattern{" +
                "data='" + data + '\'' +
                '}';
    }

    public SerializationProxyPattern(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private static class DataProxy implements Serializable{

        private static final long serialVersionUID =2087368867376448459L;
        String dataproxy;

        public DataProxy(String data) {
            this.dataproxy = "abc"+ data + "cdf";
        }

        public Object readResolve() throws InvalidObjectException {

            if(this.dataproxy.startsWith("abc") && this.dataproxy.endsWith("cdf")){
                return new SerializationProxyPattern(this.dataproxy);
            }else throw new InvalidObjectException("invalid object");

        }
    }

    public Object writeResolve(){
        return new DataProxy(data);
    }

    public void readObject(ObjectInputStream ois) throws InvalidObjectException {
            throw new InvalidObjectException("invalid read object");
    }

}
