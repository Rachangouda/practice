package problemsolving;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AlternateThreadRun {

    private static ReentrantLock lock = new ReentrantLock();
    private static volatile int nextAlphabet = 65;
    private static volatile boolean isOvel = true;
    static Condition ovelCon = lock.newCondition();
    static Condition consonantsCon = lock.newCondition();

    public static void main(String[] args) {
        Thread ovelPrinter = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    lock.lock();
                    try {
                        while (!isOvel) {
                            try {
                                ovelCon.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        AlternateThreadRun.printNextAlphabet("OVEL");
                        AlternateThreadRun.incrimentToAlphabet();
                        System.out.println("from oval:"+ nextAlphabet + lock.getHoldCount());
                        if(nextAlphabet != 65 || nextAlphabet !=69 || nextAlphabet !=73 || nextAlphabet !=79 || nextAlphabet !=85 ) {
                            isOvel = false;
                        }
                        else if (nextAlphabet > 90) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedException();
                        }
                        consonantsCon.signalAll();

                    }catch (IllegalMonitorStateException e){
                        System.out.println("ovel IllegalMonitorStateException");
                    }
                    catch (InterruptedException e){
                        System.out.println("ovel interrupted");
                    }
                    finally {
                        lock.unlock();
                        //System.out.println("oval unlocked :" + Thread.currentThread().getName() + ":" + lock.getHoldCount());
                    }
                }
            }
        });

        Thread consonantsPrinter = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 21; i++) {

                    lock.lock();

                    try {
                        while (isOvel) {
                            try {
                                consonantsCon.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        AlternateThreadRun.printNextAlphabet("CONSONANT");
                        AlternateThreadRun.incrimentToAlphabet();
                        //System.out.println("from cons:"+ nextAlphabet + lock.getHoldCount());
                        if(nextAlphabet == 65 || nextAlphabet ==69 || nextAlphabet ==73 || nextAlphabet ==79 || nextAlphabet ==85 ) {
                            isOvel = true;
                        }
                        else if (nextAlphabet > 90){
                            Thread.currentThread().interrupt();
                            throw new InterruptedException();
                        }
                        ovelCon.signalAll();
                    }catch (IllegalMonitorStateException e){
                        System.out.println("cons IllegalMonitorStateException");
                    }catch (InterruptedException e){
                        System.out.println("cons interrupted");
                    }
                    finally {
                        lock.unlock();
                        //System.out.println("cons unlocked:" + Thread.currentThread().getName() + ":" + lock.getHoldCount());
                    }
                }
            }
        });

        ovelPrinter.start();
        consonantsPrinter.start();
    }

    private static void printNextAlphabet(String tname) {
        System.out.println((char) nextAlphabet + " by "+tname);
    }
    private static void incrimentToAlphabet(){
        nextAlphabet++;
    }
}
