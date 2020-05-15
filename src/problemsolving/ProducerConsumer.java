package problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumer {

    private static Lock lock = new Lock();

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Integer MAX_SIZE = 10;


        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<MAX_SIZE;i++)
                synchronized (lock) {
                    while (list.size() == MAX_SIZE) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int x = ThreadLocalRandom.current().nextInt();
                    list.add(x);
                    System.out.println("added element:" + x);
                    lock.notifyAll();
                }
            }
        });


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<MAX_SIZE;i++)
                synchronized (lock) {
                    while (list.size() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("removed element:" + list.remove(0));


                    lock.notifyAll();
                }
            }
        });


        producer.start();
        consumer.start();


    }

    private static class Lock {
    }

}
