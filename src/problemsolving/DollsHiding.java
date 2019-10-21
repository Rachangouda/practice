package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DollsHiding {

    static int totalsize = 0;

    public static void main(String[] args) {

        //int[] array = new int[]{1, 2, 2, 3, 4, 5};//2
        //int[] array = new int[]{1, 2, 2, 3, 3, 3};//3
        //int[] array = new int[]{2, 2, 3, 3, 3};//3
        //int[] array = new int[]{2,2, 3, 3};//2
        //int[] array = new int[]{2, 3, 3};//2
        //int[] array = new int[]{2,2};//2
        int[] array = new int[]{2};//1

        System.out.println("After Hiding smaller doll into bigger Doll; Total dolls size: " + findUnhidableSize(array));
    }

    private static int findUnhidableSize(int[] array) {


        if (array.length == 0)
            return 0;

        if (array.length < 2)
            return 1;

        if (array.length == 2) {
            if (array[0] != array[1]) {
                return 1;
            } else return 2;
        }

        //int[] disticts = Arrays.stream(array).distinct().toArray();
        ArrayList<Integer> duplicates = findUnhidableDuplicates(array);

        //just to clean memory this block is useless
        /*for (int i = 0; i < disticts.length; i++) {
            map.remove((Integer) disticts[i]);
        }
*/
        int[] dup = new int[duplicates.size()];
        int i = 0;
        for (int x : duplicates) {
            dup[i++] = x;
        }

        return totalsize = 1 + findUnhidableSize(dup);
    }

    private static ArrayList<Integer> findUnhidableDuplicates(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> duplicates = new ArrayList<>();

        Arrays.stream(array).forEach(x -> consume(x, map));

        for (Integer x : map.keySet()) {
            int count = map.get(x);
            if (count > 1) {
                for (int i = 1; i < count; i++) {
                    duplicates.add(x);
                }
            }

        }
        return duplicates;
    }

    private static void consume(int item, Map<Integer, Integer> map) {

        if (map.containsKey(item)) {
            map.put(item, map.get(item).intValue() + 1);
        } else
            map.put(item, 1);
    }
}
