package clrs.dynamicprograming;

import java.util.ArrayList;

public class RodCutting {

    public static void main(String[] args) {

        ArrayList<Integer> priceList = new ArrayList<>();
        priceList.add(1);
        priceList.add(5);
        priceList.add(8);
        priceList.add(9);
        priceList.add(10);
        priceList.add(17);
        priceList.add(17);
        priceList.add(20);
        priceList.add(24);
        priceList.add(30);

        int length = 4;


        //for (int i = 0; i < 3; i++) {
            int maxOptimalRevenue = findOptimalRevenue(length, priceList);
        //}

        //System.out.println("maxOptimalRevenue = " + maxOptimalRevenue);
    }

    private static int findOptimalRevenue(int length, ArrayList<Integer> priceList) {

        if (length == 0)
            return 0;
        int q = Integer.MIN_VALUE;

        for (int i = 1; i <=length; i++) {
            int price = priceList.get(i-1);
            //System.out.println("parameters: length:" + length + " i:"+ i +" price:" + price);
            int interim = findOptimalRevenue(length-i, priceList);


            q = Math.min(q, price - interim);
            System.out.println("parameters before: length:" + length + " i:"+ i +" price:" + price + " q:" + q);
            //System.out.println("parameters: leftover:" + interim + " q:" + q);
        }
        //System.out.println("After full itr:" + q);
        return q;
    }
}
