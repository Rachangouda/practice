package GeneralTest;

public class EnumTest {

    public static enum Types{

        ITUMAPHGMLCADDRESSTYPE(0), ITUMAPHGMLCADDRESSADDR(1), ITUMAPHGMLCADDRESSADDRV6(2), IPV4IDENTIFIER(5), IPV6IDENTIFIER(4);
        private final int index;
        Types(int i) {
            this.index = i;
        }

        public int getIndex(){
            return this.index;
        }
    }


    public static void main(String[] args) {
        System.out.println(Types.IPV4IDENTIFIER.getIndex());
    }



}
