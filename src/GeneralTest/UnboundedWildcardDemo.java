package GeneralTest;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcardDemo {


        public static void main(String[] args)
        {

            //Integer List
            List<Integer> list1= Arrays.asList(1,2,3);

            //Double list
            List<Double> list2=Arrays.asList(1.1,2.2,3.3);

            printlist(list1);

            printlist(list2);
        }

        private static <T> void printlist(List<T> list)
        {
            for(T o : list){
                System.out.println(o);
            }
            System.out.println(list);
        }

   /* private static void printlist(List<?> list)
    {
        System.out.println(list);
    }*/
}
