package GeneralTest;

public class MathTest {

    public static void main(String[] args) {

        int x=-1;
        int y=3;

        System.out.println(Math.floor(32));


        Integer[] array = new Integer[]{5,4 ,-2, 7, 3, -1};

        //int k=3;



        //int side=0;//front



    }

    private static  Integer[] removedKarray(Integer[] array , int k1 , int side) {

        boolean discardleft=false;
        boolean discardright=false;
        if (side==0){//front
            int sum=0;
            int count=0;
            for(int x : array){
                if(count == k1)
                    break;
                sum+= x;
                count++;
            }
            Double z = Math.floor(sum);
            if( z.compareTo(0.0) <= 0 ){
                discardleft =true;
            }

        }

        return new Integer[]{};
    }
}
