package GeneralTest;

public class JavaPassByValueTest {


    public static void main(String args[]){

        Counter  counter = new Counter();
        System.out.println("counter identity: "+System.identityHashCode(counter));
        for (int i = 0; i < 10; i++) {
            process(counter);
        }

    }

    private static void process(Counter counter) {

        if(counter.getCount()==2) {
            System.out.println("procss counter identity before: " + System.identityHashCode(counter));
            counter = new Counter();
            System.out.println("procss counter identity before: " + System.identityHashCode(counter));
        }
        else {
            int count = counter.getCount();
            counter.setCount(++count);
        }
    }
}

class Counter{
int count=0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}