package clrs.hashtables.exercise1134;

public class ComputeSlotLocation {


    public static void main(String[] args) {

        Double A = new Double(0);
        A = (Math.sqrt(5) - 1)/2;

        Integer key = new Integer(62);

        Double fraction = new Double(0);
        fraction = (key * A) % 1;

        Integer slots = 1000;

        Double result = Math.floor(slots * fraction);

        System.out.println("Result for floor(m(kA mod 1)) where A=sqrt(5)-1 h(" + key +"):" + result);

    }
}
