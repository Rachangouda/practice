package clrs.hashtables.exercise1114;

public class MainClass {

    public static void main(String[] args) {

        HugeArrayDict dict = new HugeArrayDict(10000);

        dict.insert(1,4);
        dict.insert(1,5);
        dict.insert(1,6);

        dict.delete(1);
        dict.delete(2);

        dict.search(2);
    }
}
