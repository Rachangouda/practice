package problemsolving;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class WaterWithBarrier {


    final static Object lock = new Object();
    static CyclicBarrier barrier = new CyclicBarrier(3);
    static AtomicInteger oxCount = new AtomicInteger(0);
    static AtomicInteger hCount = new AtomicInteger(0);
    static AtomicInteger hrunCount = new AtomicInteger(0);
    static AtomicInteger orunCount = new AtomicInteger(0);

    public static String input = "HOHHHO";
    public static int oxyzenLoc = 0;
    public static int hydrogenLoc = 0;

    public static void main(String[] args) {

        Thread op = new Thread(new problemsolving.WaterGenerator.OxygenProducer());
        Thread hp = new Thread(new problemsolving.WaterGenerator.HydrogenProducer());
        Thread ct = new Thread(new problemsolving.WaterGenerator.OHConsumer());

        op.start();
        hp.start();

        ct.start();
    }


    static class OxygenProducer implements Runnable {

        @Override
        public void run() {
            while (orunCount.get() < input.length() / 3) {
                synchronized (lock) {

                    while (oxCount.get() >= 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.print("O");

                    oxCount.compareAndSet(0, 1);
                    orunCount.getAndIncrement();
                    lock.notifyAll();
                }
            }
        }
    }

    static class HydrogenProducer implements Runnable {

        @Override
        public void run() {

            while (hrunCount.get() < (input.length() / 3) * 2) {
                synchronized (lock) {


                    while (hCount.get() >= 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    System.out.print("H");
                    hCount.getAndIncrement();
                    hrunCount.getAndIncrement();
                    //System.out.print(hCount);
                    lock.notifyAll();
                }
            }

        }
    }

    static class OHConsumer implements Runnable {
        @Override
        public void run() {

            while (true) {
                synchronized (lock) {

                    while (oxCount.get() < 1 || hCount.get() < 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (oxCount.get() == 1 && hCount.get() == 2) {
                        oxCount.set(0);
                        hCount.set(0);

                    }

                    lock.notifyAll();

                }
            }

        }
    }


}
