package GeneralTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SumDivisibleBy7 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.valueOf(br.readLine());                // Reading input from STDIN
        String numbers = br.readLine();
        String[] list = numbers.split(" ");
        List<Integer> eligibles = new ArrayList<>();
        Integer tsum = Arrays.stream(list).mapToInt(x->Integer.valueOf(x)).sum();
        System.out.println("Sum "+tsum);
        int i=0;
        int location=-1;
        int minnum=Integer.MIN_VALUE;
        for (String cn : list) {
            i++;
            int exceptcurnumsum = tsum - Integer.valueOf(cn);
            //System.out.println("num " + exceptcurnumsum);
            if (isExceptCurNumSumDivisibleBy7(exceptcurnumsum)) {
                eligibles.add(Integer.valueOf(cn));
                if(minnum <= exceptcurnumsum) {
                    minnum = exceptcurnumsum;
                    location = i;
                }
            }
        }

        System.out.println("list:"+ eligibles );
        System.out.print("min value at" + location);
    }

    private static boolean isExceptCurNumSumDivisibleBy7(int exceptcurnumsum) {
        return exceptcurnumsum % 7 ==0;
    }


}
