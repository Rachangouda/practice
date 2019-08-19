package problemsolving;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class H2O {

    public H2O() {

    }
    public static String input = "OOHHHH";
    public static int oxyzenLoc=0;
    public static int hydrogenLoc=0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }

    public static void main(String args[]){

        Thread generator = new Thread(new H20Generator(), "generatorT");
        generator.start();


    }

    public static char getNextOxygenMolecule(){
        char oxygenMolecule='O';
        int inputSize = input.length();
        for (int i = oxyzenLoc; i < inputSize; i++) {
            char currecntChar = input.charAt(i);
            if(currecntChar == oxygenMolecule)
            {
                oxyzenLoc=i;
                break;
            }
            else if(i == inputSize-1) {
                System.out.println("reached end. no-more oxygen molecule");
            }
        }

        return oxygenMolecule;
    }

    public static char getNextHydrogenMolecule(){
        char hydrogenMolecule='H';
        int inputSize = input.length();
        for (int i = hydrogenLoc; i < inputSize; i++) {
            char currecntChar = input.charAt(i);
            if(currecntChar == hydrogenMolecule)
            {
                hydrogenLoc=i;
                break;
            }
            else  if(i == inputSize-1) {
                System.out.println("reached end. no-more Hydrogen molecule");
            }
        }

        return hydrogenMolecule;
    }


}

class OxygenReleaser implements Runnable{
    CyclicBarrier oxygenBarrier;
    public OxygenReleaser(CyclicBarrier oxygenBarrier){
        this.oxygenBarrier = oxygenBarrier;
    }
    @Override
    public void run() {
        System.out.print(H2O.getNextOxygenMolecule());
        /*try{
            //System.out.println(Thread.currentThread().getName());
            oxygenBarrier.await();
        }
        catch (BrokenBarrierException | InterruptedException be)
        {
            be.printStackTrace();
        }*/
    }
}

class HydrogenReleaser implements Runnable{
    CyclicBarrier hydrogenBarrier;

    HydrogenReleaser(CyclicBarrier hydrogenBarrier){
        this.hydrogenBarrier = hydrogenBarrier;
    }

    @Override
    public void run() {
        System.out.print(H2O.getNextHydrogenMolecule());

        /*try {
            //System.out.println(Thread.currentThread().getName());
            hydrogenBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }*/
    }
}

class H20Generator implements Runnable{

    @Override
    public void run() {

        CyclicBarrier completeH2OBarrier = new CyclicBarrier(3);
        CyclicBarrier oxygenBarrier = new CyclicBarrier(1);
        CyclicBarrier hydrogenBarrier = new CyclicBarrier(2);
        for (int i = 0; i < H2O.input.length() - 1; i++) {

            Thread t = new Thread(new H2OBarrierRunnable(oxygenBarrier, hydrogenBarrier));
        t.start();
    }
    }
}

class H2OBarrierRunnable implements Runnable{

    CyclicBarrier oxygenBarrier;
    CyclicBarrier hydrogenBarrier;
    public H2OBarrierRunnable(CyclicBarrier oxygenBarrier, CyclicBarrier hydrogenBarrier){
        this.oxygenBarrier = oxygenBarrier;
        this.hydrogenBarrier = hydrogenBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println();

            /*for (int i = 0; i < H2O.input.length(); i++) {
                Thread ot = new Thread(new OxygenReleaser(oxygenBarrier), "OxygenT");
                Thread ht = new Thread(new HydrogenReleaser(hydrogenBarrier), "HydrogenT");

                //System.out.println(Thread.currentThread().getName());
                ot.start();
                ht.start();
                //System.out.println(" water:" +i );
            }*/

            oxygenBarrier.await();
            System.out.print(H2O.getNextOxygenMolecule());
            hydrogenBarrier.await();
            System.out.print(H2O.getNextHydrogenMolecule());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


