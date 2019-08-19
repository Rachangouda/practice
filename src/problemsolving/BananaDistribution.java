package problemsolving;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class BananaDistribution {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter wr = new PrintWriter(System.out);
        //int T = Integer.parseInt(br.readLine().trim());
        //System.out.println(!new String(new char[15]).matches(".?|(..+?)\\1+"));
        /*for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String out_ = solve(N);
            wr.println(out_);
        }


        wr.close();
        br.close();*/
    }

    static String solve(int N) {
        // Your code goes here
        String canBeDistributed="No";
        int predictedNoOfPeople= predicteNoOfPeople(N);

        if (predictedNoOfPeople > 0)
            canBeDistributed="Yes";
        BigInteger b = new BigInteger(String.valueOf(N));
        b.isProbablePrime(1);
        return canBeDistributed;


    }

    private static int predicteNoOfPeople(int nBananas) {
        final Integer minGroupSize=2;
        int predictedSize = Integer.MIN_VALUE;
        if (nBananas <= 3)
            return predictedSize;

        //int leftover = (nBananas % minGroupSize);
        //if(leftover == 0)
            predictedSize = nBananas/2;


        return predictedSize;
    }
}